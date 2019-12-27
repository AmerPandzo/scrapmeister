package com.scraper.controller;

import com.scraper.domain.EntryParseRule;
import com.scraper.domain.TargetWebsite;
import com.scraper.service.EntryParseRuleService;
import com.scraper.service.TargetWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @Autowired
  public TargetWebsiteController(TargetWebsiteService targetWebsiteService,
      EntryParseRuleService entryParseRuleService) {
    this.targetWebsiteService = targetWebsiteService;
    this.entryParseRuleService = entryParseRuleService;
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

  @GetMapping("/targetWebsites")
  public List<TargetWebsite> findAll() throws IOException {
    System.out.println("Getting all target websites.");
    return targetWebsiteService.findAll();
  }

  @GetMapping("/targetWebsites/{id}")
  public Optional<TargetWebsite> findById(@PathVariable Long id) throws IOException {
    System.out.println("Getting target website.");
    return targetWebsiteService.findById(id);
  }
}
