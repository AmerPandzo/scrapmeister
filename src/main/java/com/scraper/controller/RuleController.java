package com.scraper.controller;

import com.scraper.model.domain.Rule;
import com.scraper.service.impl.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import javax.validation.Valid;

@RestController
public class RuleController {

  @Autowired
  private RuleService ruleService;

  @PostMapping("/rule")
  @ResponseBody
  public Rule create(@RequestBody @Valid final Rule rule) throws IOException {
    System.out.println("Creating entity rule.");
    return ruleService.create(rule);
  }
}
