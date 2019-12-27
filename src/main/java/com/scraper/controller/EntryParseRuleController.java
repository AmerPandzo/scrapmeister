package com.scraper.controller;

import com.scraper.domain.EntryParseRule;
import com.scraper.service.EntryParseRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import javax.validation.Valid;

@RestController
public class EntryParseRuleController {

  @Autowired
  private EntryParseRuleService entryParseRuleService;

  @CrossOrigin(origins = {"http://localhost:4200", "https://scrapmeister-frontend.herokuapp.com"})
  @PostMapping("/entryParseRule")
  @ResponseBody
  public EntryParseRule create(@RequestBody @Valid final EntryParseRule entryParseRule) throws IOException {
    System.out.println("Creating entity rule.");
    return entryParseRuleService.create(entryParseRule);
  }
}
