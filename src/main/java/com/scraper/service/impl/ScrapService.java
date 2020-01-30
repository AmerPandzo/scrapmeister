package com.scraper.service.impl;

import com.scraper.ScrapUtils;
import com.scraper.model.domain.Feed;
import com.scraper.model.domain.Rule;
import com.scraper.model.domain.Website;
import com.scraper.repository.WebsiteRepository;
import com.scraper.service.IFeedService;
import com.scraper.service.IScrapService;
import com.scraper.service.IWebsiteService;
import javassist.NotFoundException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
@Transactional
public class ScrapService implements IScrapService {

  private WebsiteRepository websiteRepository;
  private IFeedService feedService;

  @Autowired
  public ScrapService(WebsiteRepository websiteRepository, FeedService feedService) {
    this.websiteRepository = websiteRepository;
    this.feedService = feedService;
  }

  public List<Feed> scrapOneAndSave(Long id) throws IOException, NotFoundException {
    Optional<Website> maybeSite = websiteRepository.findById(id);
    if (!maybeSite.isPresent()) {
      throw new NotFoundException("Website for scraping not found!");
    }
    entriesCleanupForOne(id);
    processWebsiteScrapping(maybeSite.get());
    return feedService.findAllByWebsiteId(id);
  }

  public String scrapAndSave() throws IOException {
    List<Website> websites = websiteRepository.findAll();
    System.out.println("Number of websites scraped: " + websites.size());
    entriesCleanup();
    processWebsitesScrapping(websites);
    return "Website scraped: " + websites.size();
  }

  private void processWebsitesScrapping(List<Website> websites) throws IOException {
    for (Website website : websites) {
      processWebsiteScrapping(website);
    }
  }

  private void processWebsiteScrapping(Website website) throws IOException {
    Document doc = Jsoup.connect(website.getUrl()).get();
    String websiteTitle = doc.title();
    System.out.println(websiteTitle);
    Elements elements = doc.select(website.getRules().stream().findFirst().get().getNewsContainer());
    elements.forEach(element -> saveFeed(element, website, websiteTitle));
  }

  private void entriesCleanup() {
    feedService.deleteAll();
  }

  private void entriesCleanupForOne(Long id) {
    feedService.deleteAllByWebsiteId(id);
  }

  private Feed saveFeed(Element element, Website website, String websiteTitle) {
    Rule rule = website.getRules().stream().findFirst().get();
    String imageUrl = "no image";
    if (element.select("img").first() != null) {
      imageUrl = element.select("img").first().absUrl("src");
    }
    return feedService.save(
        Feed.FeedBuilder.aFeed()
            .setAuthor(websiteTitle)
            .setTitle(element.select(rule.getTitle()).text())
            .setContent(
                ScrapUtils.generateContent(
                    element.select(rule.getContent()).text(),
                    imageUrl
                )
            )
            .setUrl(element.select(rule.getLink()).attr("abs:href"))
            .setImageUrl(imageUrl)
            .setWebsite(website)
            .setCratedAt(LocalDateTime.now())
            .build());
  }

}