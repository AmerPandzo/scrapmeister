package com.scraper.service;

import com.scraper.domain.FeedEntry;
import com.scraper.repository.FeedEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedEntryService {

  @Autowired
  private FeedEntryRepository feedEntryRepository;

  public FeedEntry save(FeedEntry feedEntry) {
    return feedEntryRepository.save(feedEntry);
  }

  public List<FeedEntry> findAll() {
    return feedEntryRepository.findAll();
  }

  public List<FeedEntry> findAllByTargetWebsiteId(Long targetWebsiteId) {
    return feedEntryRepository.findAllByTargetWebsiteId(targetWebsiteId);
  }

  public void deleteAllByTargetWebsiteId(Long targetWebsiteId) {
    feedEntryRepository.deleteAllByTargetWebsiteId(targetWebsiteId);
  }

  public void deleteAll() {
    feedEntryRepository.deleteAll();
  }
}