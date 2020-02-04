package com.scraper.service.impl;

import com.scraper.mapper.WebsiteMapper;
import com.scraper.model.domain.Rule;
import com.scraper.model.request.RuleRequest;
import com.scraper.model.response.Response;
import com.scraper.repository.RuleRepository;
import com.scraper.service.IRuleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
@Transactional
public class RuleService implements IRuleService {

  private RuleRepository ruleRepository;

  @Autowired
  public RuleService(RuleRepository ruleRepository) {
    this.ruleRepository = ruleRepository;
  }

  public List<Rule> findAll() {
    return ruleRepository.findAll();
  }

  public Rule create(Rule rule) {
    rule.setCratedAt(LocalDateTime.now());
    return ruleRepository.save(rule);
  }

  public Response update(RuleRequest newRule) throws NotFoundException {
    final Optional<Rule> maybeRule = ruleRepository.findById(newRule.getId());
    if (!maybeRule.isPresent()) throw new NotFoundException("Rule not found.");
    final Rule rule = maybeRule.get();
    rule.setNewsContainer(newRule.getNewsContainer());
    rule.setTitle(newRule.getTitle());
    rule.setLink(newRule.getLink());
    rule.setContent(newRule.getContent());
    return WebsiteMapper.fromRuleToRuleResponse(ruleRepository.save(rule));
  }

  @Override
  public Response findByWebsiteId(final Long websiteId) {
    final List<Rule> maybeRule = ruleRepository.findByWebsiteId(websiteId);
    return WebsiteMapper.fromRuleToRuleResponse(maybeRule.get(0));
  }
}
