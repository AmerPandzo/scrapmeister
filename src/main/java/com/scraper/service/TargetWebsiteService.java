package com.scraper.service;

import com.scraper.domain.EntryParseRule;
import com.scraper.domain.TargetWebsite;
import com.scraper.repository.TargetWebsiteRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
@Transactional
public class TargetWebsiteService {

  private TargetWebsiteRepository targetWebsiteRepository;

  @Autowired
  public TargetWebsiteService(TargetWebsiteRepository targetWebsiteRepository) {
    this.targetWebsiteRepository = targetWebsiteRepository;
  }

  public List<TargetWebsite> findAll() {
    return targetWebsiteRepository.findAll();
  }

  public List<TargetWebsite> findAllByIds(List<Long> ids) {
    return targetWebsiteRepository.findAllById(ids);
  }

  public Optional<TargetWebsite> findById(Long id) {
    return targetWebsiteRepository.findById(id);
  }

  public void deleteById(Long id) {
    targetWebsiteRepository.deleteById(id);
  }

  public TargetWebsite create(TargetWebsite targetWebsite) {
    return targetWebsiteRepository.save(targetWebsite);
  }

  public TargetWebsite update(TargetWebsite newTargetWebsite) throws NotFoundException {
    Optional<TargetWebsite> maybeTargetWebsite = targetWebsiteRepository.findById(newTargetWebsite.getId());
    if(!maybeTargetWebsite.isPresent()) throw new NotFoundException("TargetWebsite not found.");
    final TargetWebsite targetWebsite = maybeTargetWebsite.get();
    targetWebsite.setUrl(newTargetWebsite.getUrl());
    targetWebsite.setEntryParseRule(newTargetWebsite.getEntryParseRule());
    return targetWebsiteRepository.save(targetWebsite);
  }

}