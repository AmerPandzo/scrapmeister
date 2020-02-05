package com.scraper.facade;

import com.scraper.model.response.ResponseList;
import com.scraper.service.impl.FeedService;
import com.scraper.service.impl.ScrapService;
import com.scraper.service.impl.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Component
public class WebsiteFacade {

  WebsiteService websiteService;

  ScrapService scrapService;

  FeedService feedService;

  @Autowired
  public WebsiteFacade(WebsiteService websiteService,
      FeedService feedService,
      ScrapService scrapService) {
    this.websiteService = websiteService;
    this.feedService = feedService;
    this.scrapService = scrapService;
  }

  @GetMapping("/scrap")
  @ResponseBody
  public String scrap() throws IOException {
    System.out.println("Scrap and save.");
    ResponseList websites = websiteService.findAll();
    return scrapService.scrapAndSave(websites.getPlainResponses());
  }

  public String scrapChildren(final Long id) throws IOException {
    System.out.println("Scrap and save.");
    ResponseList childrenById = websiteService.findChildrenById(id);
    return scrapService.scrapAndSave(childrenById.getPlainResponses());
  }

}
