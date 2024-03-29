package com.scraper.controller;

import com.scraper.domain.EntryParseRule;
import com.scraper.domain.FeedEntry;
import com.scraper.domain.TargetWebsite;
import com.scraper.service.EntryParseRuleService;
import com.scraper.service.FeedEntryService;
import com.scraper.service.TargetWebsiteService;
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
public class TargetWebsiteController {

  private TargetWebsiteService targetWebsiteService;

  private EntryParseRuleService entryParseRuleService;

  private FeedEntryService feedEntryService;

  @Autowired
  public TargetWebsiteController(TargetWebsiteService targetWebsiteService,
      EntryParseRuleService entryParseRuleService,
      FeedEntryService feedEntryService) {
    this.targetWebsiteService = targetWebsiteService;
    this.entryParseRuleService = entryParseRuleService;
    this.feedEntryService = feedEntryService;
  }

  @PostMapping("/targetWebsites")
  @ResponseBody
  public TargetWebsite create(@RequestBody @Valid final TargetWebsite targetWebsite) throws IOException {
    System.out.println("Creating target website.");
    EntryParseRule entryParseRule = targetWebsite.getEntryParseRule();
    final LocalDateTime cratedAt = LocalDateTime.now();
    entryParseRule.setCratedAt(cratedAt);
    entryParseRuleService.create(entryParseRule);
    targetWebsite.setCreatedAt(cratedAt);
    return targetWebsiteService.create(targetWebsite);
  }

  @PutMapping("/targetWebsites/update")
  @ResponseBody
  public TargetWebsite update(@RequestBody @Valid final TargetWebsite targetWebsite) throws NotFoundException {
    System.out.println("Updating target website.");
    EntryParseRule entryParseRule = targetWebsite.getEntryParseRule();
    entryParseRuleService.update(entryParseRule);
    return targetWebsiteService.update(targetWebsite);
  }

  @GetMapping("/targetWebsites")
  public List<TargetWebsite> findAll(@RequestParam Optional<List<Long>> ids) throws IOException {
    List<TargetWebsite> targetWebsites;
    if (!ids.isPresent()) {
      System.out.println("Getting all target websites.");
      targetWebsites = targetWebsiteService.findAll();
    } else {
      System.out.println("Getting all target websites by list of ids.");
      targetWebsites = targetWebsiteService.findAllByIds(ids.get());
    }
    return targetWebsites;
  }

  @GetMapping("/targetWebsites/byIds")
  public List<TargetWebsite> findAllByIds(@RequestParam List<Long> ids) throws IOException {
    System.out.println("Getting all target websites by list of ids.");
    return targetWebsiteService.findAllByIds(ids);
  }

  @GetMapping("/targetWebsites/{id}")
  public Optional<TargetWebsite> findById(@PathVariable Long id) throws IOException {
    System.out.println("Getting target website.");
    return targetWebsiteService.findById(id);
  }

  @DeleteMapping("/targetWebsites/{id}")
  public void deleteById(@PathVariable Long id) throws IOException {
    System.out.println("Deleting target website.");
    targetWebsiteService.deleteById(id);
  }

  @DeleteMapping("/targetWebsites/{id}/feeds")
  public void deleteAllFeedsById(@PathVariable Long id) throws IOException {
    System.out.println("Deleting target website.");
    feedEntryService.deleteAllByTargetWebsiteId(id);
    targetWebsiteService.deleteById(id);
  }

  @GetMapping("/targetWebsites/{targetWebsiteId}/feed/{id}")
  public Optional<FeedEntry> getByIdAndTargetWebsiteId(@PathVariable Long id,
      @PathVariable Long targetWebsiteId) throws IOException {
    System.out.println("Getting feed by target website.");
    return feedEntryService.findByIdAndTargetWebsiteId(id, targetWebsiteId);
  }

  @DeleteMapping("/targetWebsites/{targetWebsiteId}/feed/{id}")
  public void deleteByIdAndTargetWebsiteId(@PathVariable Long id, @PathVariable Long targetWebsiteId) throws IOException {
    System.out.println("Deleting feed by target website.");
    feedEntryService.deleteByIdAndTargetWebsiteId(id, targetWebsiteId);
  }

  @GetMapping("/targetWebsites/{id}/feeds")
  public List<FeedEntry> getFeedsById(@PathVariable Long id) {
    System.out.println("Getting feeds by website.");
    return feedEntryService.findAllByTargetWebsiteId(id);
  }
}
