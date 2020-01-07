package com.scraper.service;

import com.scraper.domain.EntryParseRule;
import com.scraper.repository.EntryParseRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;

@Service
@Transactional
public class EntryParseRuleService {

  private EntryParseRuleRepository entryParseRuleRepository;

  @Autowired
  public EntryParseRuleService(EntryParseRuleRepository entryParseRuleRepository) {
    this.entryParseRuleRepository = entryParseRuleRepository;
  }

  public List<EntryParseRule> findAll() {
    return entryParseRuleRepository.findAll();
  }

  public EntryParseRule create(EntryParseRule entryParseRule) {
    entryParseRule.setCratedAt(LocalDateTime.now());
    return entryParseRuleRepository.save(entryParseRule);
  }
}
