package com.scraper.controller;

import com.scraper.domain.Rule;
import com.scraper.domain.Feed;
import com.scraper.domain.Website;
import com.scraper.service.RuleService;
import com.scraper.service.FeedService;
import com.scraper.service.WebsiteService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

@RestController
public class WebsiteController {

  private WebsiteService websiteService;

  private RuleService ruleService;

  private FeedService feedService;

  @Autowired
  public WebsiteController(WebsiteService websiteService,
      RuleService ruleService,
      FeedService feedService) {
    this.websiteService = websiteService;
    this.ruleService = ruleService;
    this.feedService = feedService;
  }

  @PostMapping("/websites")
  @ResponseBody
  public Website create(@RequestBody @Valid final Website website) throws IOException {
    System.out.println("Creating target website.");
    List<Rule> rules = website.getRules();
    final LocalDateTime cratedAt = LocalDateTime.now();
    rules.forEach(rule ->
        rule.setCratedAt(cratedAt)
    );
    website.setRules(rules);
    //ruleService.create(rule);
    website.setCreatedAt(cratedAt);
    return websiteService.create(website);
  }

  @PutMapping("/websites/update")
  @ResponseBody
  public Website update(@RequestBody @Valid final Website website) throws NotFoundException {
    System.out.println("Updating target website.");
    //Rule rule = website.getRule();
    //ruleService.update(rule);
    return websiteService.update(website);
  }

  @GetMapping("/websites")
  public List<Website> findAll(@RequestParam Optional<List<Long>> ids) throws IOException {
    List<Website> websites;
    if (!ids.isPresent()) {
      System.out.println("Getting all target website.");
      websites = websiteService.findAll();
    } else {
      System.out.println("Getting all target website by list of ids.");
      websites = websiteService.findAllByIds(ids.get());
    }
    return websites;
  }

  @GetMapping("/websites/byIds")
  public List<Website> findAllByIds(@RequestParam List<Long> ids) throws IOException {
    System.out.println("Getting all target website by list of ids.");
    return websiteService.findAllByIds(ids);
  }

  @GetMapping("/websites/{id}")
  public Optional<Website> findById(@PathVariable Long id) throws IOException {
    System.out.println("Getting target websites.");
    return websiteService.findById(id);
  }

  @DeleteMapping("/websites/{id}")
  public void deleteById(@PathVariable Long id) throws IOException {
    System.out.println("Deleting target websites.");
    websiteService.deleteById(id);
  }

  @DeleteMapping("/websites/{id}/feeds")
  public void deleteAllFeedsById(@PathVariable Long id) throws IOException {
    System.out.println("Deleting target websites.");
    feedService.deleteAllByWebsiteId(id);
    websiteService.deleteById(id);
  }

  @GetMapping("/websites/{websiteId}/feed/{id}")
  public Optional<Feed> getByIdAndWebsiteId(@PathVariable Long id,
      @PathVariable Long websiteId) throws IOException {
    System.out.println("Getting feed by target websites.");
    return feedService.findByIdAndWebsiteId(id, websiteId);
  }

  @DeleteMapping("/websites/{websiteId}/feed/{id}")
  public void deleteByIdAndWebsiteId(@PathVariable Long id, @PathVariable Long websiteId) throws IOException {
    System.out.println("Deleting feed by target websites.");
    feedService.deleteByIdAndWebsiteId(id, websiteId);
  }

  @GetMapping("/websites/{id}/feeds")
  public List<Feed> getFeedsById(@PathVariable Long id) {
    System.out.println("Getting feeds by websites.");
    return feedService.findAllByWebsiteId(id);
  }
}
