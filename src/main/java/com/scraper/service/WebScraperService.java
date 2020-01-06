package com.scraper.service;

import com.scraper.WebScraperUtils;
import com.scraper.domain.EntryParseRule;
import com.scraper.domain.FeedEntry;
import com.scraper.domain.TargetWebsite;
import javassist.NotFoundException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class WebScraperService {

  private TargetWebsiteService targetWebsiteService;
  private FeedEntryService feedEntryService;

  @Autowired
  public WebScraperService(TargetWebsiteService targetWebsiteService, FeedEntryService feedEntryService) {
    this.targetWebsiteService = targetWebsiteService;
    this.feedEntryService = feedEntryService;
  }

  public List<FeedEntry> scrapOneAndSave(Long id) throws IOException, NotFoundException {
    Optional<TargetWebsite> maybeWebsite = targetWebsiteService.findById(id);
    if(!maybeWebsite.isPresent()) {
      throw new NotFoundException("Website for scraping not found!");
    }
    entriesCleanupForOne(id);
    processWebsiteScrapping(maybeWebsite.get());
    return feedEntryService.findAllByTargetWebsiteId(id);
  }

  public String scrapAndSave() throws IOException {
    List<TargetWebsite> websites = targetWebsiteService.findAll();
    System.out.println("number of websites scraped: " + websites.size());
    entriesCleanup();
    processWebsitesScrapping(websites);
    return "Websites scraped: " + websites.size();
  }

  private void processWebsitesScrapping(List<TargetWebsite> websites) throws IOException {
    for (TargetWebsite website : websites) {
      processWebsiteScrapping(website);
      //log.info("Scrapped website: " + websiteTitle + ". " + elements.size() + " entries added to feed.");
    }
  }

  private void processWebsiteScrapping(TargetWebsite website) throws IOException {
      Document doc = Jsoup.connect(website.getUrl()).get();
      String websiteTitle = doc.title();
      System.out.println(websiteTitle);
      Elements elements = doc.select(website.getEntryParseRule().getNewsContainer());
      elements.forEach(element -> saveEntry(element, website, websiteTitle));
  }

  private void entriesCleanup() {
    feedEntryService.deleteAll();
  }

  private void entriesCleanupForOne(Long id) {
    feedEntryService.deleteAllByTargetWebsiteId(id);
  }

  private FeedEntry saveEntry(Element element, TargetWebsite website, String websiteTitle) {
    EntryParseRule rule = website.getEntryParseRule();
    String imageUrl = "no image";
   if(element.select("img").first() != null) {
       imageUrl = element.select("img").first().absUrl("src");
   }
    return feedEntryService.save(
        FeedEntry.FeedEntryBuilder.aFeedEntry()
            .setAuthor(websiteTitle)
            .setTitle(element.select(rule.getTitle()).text())
            .setContent(
                WebScraperUtils.generateContent(
                    element.select(rule.getContent()).text(),
                    imageUrl
                )
            )
            .setUrl(element.select(rule.getLink()).attr("abs:href"))
            .setImageUrl(imageUrl)
            .setTargetWebsite(website)
            .build());
  }

}