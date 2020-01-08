package com.scraper.service;

import com.scraper.domain.EntryParseRule;
import com.scraper.repository.EntryParseRuleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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

  public EntryParseRule update(EntryParseRule newEntryParseRule) throws NotFoundException {
    final Optional<EntryParseRule> maybeEntryParseRule = entryParseRuleRepository.findById(newEntryParseRule.getId());
    if(!maybeEntryParseRule.isPresent()) throw new NotFoundException("EntryParseRule not found.");
    final EntryParseRule entryParseRule = maybeEntryParseRule.get();
    entryParseRule.setNewsContainer(newEntryParseRule.getNewsContainer());
    entryParseRule.setTitle(newEntryParseRule.getTitle());
    entryParseRule.setLink(newEntryParseRule.getLink());
    entryParseRule.setContent(newEntryParseRule.getContent());
    return entryParseRuleRepository.save(entryParseRule);
  }
}
