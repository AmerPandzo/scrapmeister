package com.scraper.service;

import com.scraper.model.domain.Rule;
import com.scraper.model.request.RuleRequest;
import com.scraper.model.response.Response;
import javassist.NotFoundException;

import java.util.List;

public interface IRuleService {

  List<Rule> findAll();

  Rule create(Rule rule);

  Response update(RuleRequest ruleRequest) throws NotFoundException;

  Response findByWebsiteId(Long websiteId);
}
