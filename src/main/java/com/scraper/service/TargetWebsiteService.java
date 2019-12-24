package com.scraper.service;

import com.scraper.domain.TargetWebsite;
import com.scraper.repository.TargetWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetWebsiteService {

  private TargetWebsiteRepository targetWebsiteRepository;

  @Autowired
  public TargetWebsiteService(TargetWebsiteRepository targetWebsiteRepository) {
    this.targetWebsiteRepository = targetWebsiteRepository;
  }

  public List<TargetWebsite> findAll() {
    return targetWebsiteRepository.findAll();
  }

}