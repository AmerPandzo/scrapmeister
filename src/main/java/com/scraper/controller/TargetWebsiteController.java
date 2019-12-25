package com.scraper.controller;

import com.scraper.domain.EntryParseRule;
import com.scraper.domain.TargetWebsite;
import com.scraper.service.EntryParseRuleService;
import com.scraper.service.TargetWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
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

  @PostMapping("/targetWebsite")
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
}
