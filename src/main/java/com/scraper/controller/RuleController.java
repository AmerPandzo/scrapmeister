package com.scraper.controller;

import com.scraper.model.domain.Rule;
import com.scraper.model.response.Response;
import com.scraper.service.impl.RuleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @PostMapping("/rules")
  @ResponseBody
  public Rule create(@RequestBody @Valid final Rule rule) throws IOException {
    System.out.println("Creating entity rule.");
    return ruleService.create(rule);
  }

  @GetMapping("/rules/{websiteId}")
  @ResponseBody
  public Response findByWebsiteId(@PathVariable final Long websiteId) throws NotFoundException {
    System.out.println("Getting entity rule by website.");
    return ruleService.findByWebsiteId(websiteId);
  }
}
