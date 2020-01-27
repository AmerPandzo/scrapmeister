package com.scraper.mapper;

import com.scraper.model.domain.Rule;
import com.scraper.model.domain.Website;
import com.scraper.model.request.WebsiteRequest;
import com.scraper.model.response.WebsiteResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class WebsiteMapper {

  private WebsiteMapper() {
    // prevent instantiation
  }

  public static Website fromWebsiteRequestToWebsite(final WebsiteRequest websiteRequest) {
    final LocalDateTime cratedAt = LocalDateTime.now();
    Website website = new Website();
    website.setUrl(websiteRequest.getUrl());
    website.setCreatedAt(cratedAt);
    website.setUpdatedAt(cratedAt);
    List<Rule> rules = new ArrayList<>();
    websiteRequest.getRules().forEach(rule -> {
      Rule newRule = new Rule();
      newRule.setContent(rule.getContent());
      newRule.setLink(rule.getLink());
      newRule.setNewsContainer(rule.getNewsContainer());
      newRule.setTitle(rule.getTitle());
      newRule.setCratedAt(cratedAt);
      rules.add(newRule);
    });
    website.setRules(rules);
    return website;
  }

  public static WebsiteResponse fromWebsiteToWebsiteResponse(final Website website) {
    WebsiteResponse websiteResponse = new WebsiteResponse();
    websiteResponse.setUrl(website.getUrl());
    websiteResponse.setRules(website.getRules());
    websiteResponse.setCreatedAt(website.getCreatedAt());
    websiteResponse.getUpdatedAt(website.getUpdatedAt());
    websiteResponse.setParent(website.getParent());
    websiteResponse.setChildren(new ArrayList<>(website.getChildren()));
    return websiteResponse;
  }
}
