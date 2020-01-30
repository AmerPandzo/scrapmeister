package com.scraper.mapper;

import com.scraper.model.domain.Rule;
import com.scraper.model.domain.Website;
import com.scraper.model.request.WebsiteRequest;
import com.scraper.model.response.PlainWebsiteResponse;
import com.scraper.model.response.WebsiteResponse;
import com.scraper.model.response.WebsiteResponseList;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    Set<Rule> rules = new HashSet<>();
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
    if (website.getChildren() != null) {
      websiteResponse.setChildren(new HashSet<>(website.getChildren()));
    }
    return websiteResponse;
  }

  public static PlainWebsiteResponse fromWebsiteToPlainWebsiteResponse(final Website website) {
    PlainWebsiteResponse websiteResponse = new PlainWebsiteResponse();
    websiteResponse.setUrl(website.getUrl());
    websiteResponse.setRules(website.getRules());
    websiteResponse.setCreatedAt(website.getCreatedAt());
    websiteResponse.getUpdatedAt(website.getUpdatedAt());
    websiteResponse.setParent(website.getParent());
    if (website.getChildren() != null) {
      websiteResponse.setChildren(new HashSet<>(website.getChildren()));
    }
    return websiteResponse;
  }

  public static WebsiteResponseList fromWebsitesToWebsiteResponseList(final List<Website> websites) {
    List<PlainWebsiteResponse> websiteResponses = new ArrayList<>();
    websites.forEach(website -> websiteResponses.add(fromWebsiteToPlainWebsiteResponse(website)));
    WebsiteResponseList websiteResponseList = new WebsiteResponseList();
    websiteResponseList.setMessage("Successfully fetched list.");
    websiteResponseList.setStatus(HttpStatus.OK);
    websiteResponseList.setPlainWebsiteResponses(websiteResponses);
    return websiteResponseList;
  }
}
