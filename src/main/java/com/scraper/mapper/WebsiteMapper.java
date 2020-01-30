package com.scraper.mapper;

import com.scraper.model.domain.Feed;
import com.scraper.model.domain.Rule;
import com.scraper.model.domain.Website;
import com.scraper.model.request.WebsiteRequest;
import com.scraper.model.response.PlainFeedResponse;
import com.scraper.model.response.PlainWebsiteResponse;
import com.scraper.model.response.WebsiteResponse;
import com.scraper.model.response.ResponseList;
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

  public static PlainFeedResponse fromFeedToFeedResponse(final Feed feed) {
    PlainFeedResponse plainFeedResponse = new PlainFeedResponse();
    plainFeedResponse.setUrl(feed.getUrl());
    plainFeedResponse.setAuthor(feed.getAuthor());
    plainFeedResponse.setContent(feed.getContent());
    plainFeedResponse.setCratedAt(feed.getCratedAt());
    plainFeedResponse.setImageUrl(feed.getImageUrl());
    plainFeedResponse.setTitle(feed.getTitle());
    return plainFeedResponse;
  }

  public static ResponseList fromWebsitesToWebsiteResponseList(final List<Website> websites) {
    List<PlainWebsiteResponse> websiteResponses = new ArrayList<>();
    websites.forEach(website -> websiteResponses.add(fromWebsiteToPlainWebsiteResponse(website)));
    ResponseList responseList = new ResponseList();
    responseList.setMessage("Successfully fetched list.");
    responseList.setStatus(HttpStatus.OK);
    responseList.setPlainResponses(websiteResponses);
    return responseList;
  }

  public static ResponseList fromFeedToWebsiteResponseList(final List<Feed> feeds) {
    List<PlainFeedResponse> websiteResponses = new ArrayList<>();
    feeds.forEach(feed -> websiteResponses.add(fromFeedToFeedResponse(feed)));
    ResponseList responseList = new ResponseList();
    responseList.setMessage("Successfully fetched list.");
    responseList.setStatus(HttpStatus.OK);
    responseList.setPlainResponses(websiteResponses);
    return responseList;
  }
}