package com.scraper.mapper;

import com.scraper.model.domain.Feed;
import com.scraper.model.domain.Rule;
import com.scraper.model.domain.Website;
import com.scraper.model.request.FeedRequest;
import com.scraper.model.request.RuleRequest;
import com.scraper.model.request.WebsiteRequest;
import com.scraper.model.response.PlainFeedResponse;
import com.scraper.model.response.PlainWebsiteResponse;
import com.scraper.model.response.ResponseList;
import com.scraper.model.response.RuleResponse;
import com.scraper.model.response.WebsiteResponse;
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
    website.setTitle(websiteRequest.getTitle());
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

  public static Rule fromRuleRequestToRule(final RuleRequest ruleRequest) {
    final LocalDateTime cratedAt = LocalDateTime.now();
    Rule rule = new Rule();
    rule.setContent(ruleRequest.getContent());
    rule.setLink(ruleRequest.getLink());
    rule.setNewsContainer(ruleRequest.getNewsContainer());
    rule.setTitle(ruleRequest.getTitle());
    rule.setCratedAt(cratedAt);
    return rule;
  }

  public static Set<Rule> fromRuleRequestsToRules(final List<RuleRequest> ruleRequestList) {
    Set<Rule> rules = new HashSet<>();
    ruleRequestList.forEach(ruleRequest -> rules.add(fromRuleRequestToRule(ruleRequest)));
    return rules;
  }

  public static RuleResponse fromRuleToRuleResponse(final Rule rule) {
    RuleResponse ruleResponse = new RuleResponse();
    ruleResponse.setContent(rule.getContent());
    ruleResponse.setCratedAt(rule.getCratedAt());
    ruleResponse.setLink(rule.getLink());
    ruleResponse.setNewsContainer(rule.getNewsContainer());
    ruleResponse.setTitle(rule.getTitle());
    return ruleResponse;
  }

  public static WebsiteResponse fromWebsiteToWebsiteResponse(final Website website) {
    WebsiteResponse websiteResponse = new WebsiteResponse();
    websiteResponse.setTitle(website.getTitle());
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
    websiteResponse.setTitle(website.getTitle());
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

  public static PlainFeedResponse fromFeedToPlainFeedResponse(final Feed feed) {
    PlainFeedResponse plainFeedResponse = new PlainFeedResponse();
    plainFeedResponse.setUrl(feed.getUrl());
    plainFeedResponse.setAuthor(feed.getAuthor());
    plainFeedResponse.setContent(feed.getContent());
    plainFeedResponse.setCratedAt(feed.getCratedAt());
    plainFeedResponse.setImageUrl(feed.getImageUrl());
    plainFeedResponse.setTitle(feed.getTitle());
    return plainFeedResponse;
  }

  public static Feed fromFeedRequestToFeed(final FeedRequest feedRequest) {
    final LocalDateTime cratedAt = LocalDateTime.now();
    Feed feed = new Feed();
    feed.setUrl(feedRequest.getUrl());
    feed.setAuthor(feedRequest.getAuthor());
    feed.setContent(feedRequest.getContent());
    feed.setCratedAt(cratedAt);
    feed.setImageUrl(feedRequest.getImageUrl());
    feed.setTitle(feedRequest.getTitle());
    return feed;
  }

  public static ResponseList<PlainWebsiteResponse> fromWebsitesToWebsiteResponseList(final List<Website> websites) {
    List<PlainWebsiteResponse> websiteResponses = new ArrayList<>();
    websites.forEach(website -> websiteResponses.add(fromWebsiteToPlainWebsiteResponse(website)));
    ResponseList<PlainWebsiteResponse> responseList = new ResponseList();
    responseList.setMessage("Successfully fetched list.");
    responseList.setStatus(HttpStatus.OK);
    responseList.setPlainResponses(websiteResponses);
    return responseList;
  }

  public static ResponseList<PlainFeedResponse> fromFeedToFeedResponseList(final List<Feed> feeds) {
    List<PlainFeedResponse> websiteResponses = new ArrayList<>();
    feeds.forEach(feed -> websiteResponses.add(fromFeedToPlainFeedResponse(feed)));
    ResponseList<PlainFeedResponse> responseList = new ResponseList();
    responseList.setMessage("Successfully fetched list.");
    responseList.setStatus(HttpStatus.OK);
    responseList.setCount(websiteResponses.size());
    responseList.setPlainResponses(websiteResponses);
    return responseList;
  }
}
