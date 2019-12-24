package com.scraper.service;

import com.scraper.WebScraperUtils;
import com.scraper.domain.EntryParseRule;
import com.scraper.domain.FeedEntry;
import com.scraper.domain.TargetWebsite;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class WebScraperService {

  private TargetWebsiteService targetWebsiteService;
  private FeedEntryService feedEntryService;

  @Autowired
  public WebScraperService(TargetWebsiteService targetWebsiteService, FeedEntryService feedEntryService) {
    this.targetWebsiteService = targetWebsiteService;
    this.feedEntryService = feedEntryService;
  }

  public void scrapAndSave() throws IOException {
    List<TargetWebsite> websites = targetWebsiteService.findAll();
    entriesCleanup();
    processWebsitesScrapping(websites);
    //log.info("Total: " + websites.size() + " websites scrapped.");
  }

  private void processWebsitesScrapping(List<TargetWebsite> websites) throws IOException {
    for (TargetWebsite website : websites) {
      Document doc = Jsoup.connect(website.getUrl()).get();
      String websiteTitle = doc.title();
      Elements elements = doc.select(website.getEntryParseRule().getNewsContainer());
      elements.forEach(element -> saveEntry(element, website, websiteTitle));
      //log.info("Scrapped website: " + websiteTitle + ". " + elements.size() + " entries added to feed.");
    }
  }

  private void entriesCleanup() {
    feedEntryService.deleteAll();
  }

  private FeedEntry saveEntry(Element element, TargetWebsite website, String websiteTitle) {
    EntryParseRule rule = website.getEntryParseRule();
    String imageUrl = element.select("img").first().absUrl("src");
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