package com.scraper.service;

import com.scraper.domain.Feed;
import com.scraper.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
@Transactional
public class FeedService {

  @Autowired
  private FeedRepository feedRepository;

  public Feed save(Feed feed) {
    return feedRepository.save(feed);
  }

  public List<Feed> findAll() {
    return feedRepository.findAll();
  }

  public List<Feed> findAllByWebsiteId(Long websiteId) {
    return feedRepository.findAllByWebsiteId(websiteId);
  }

  public Optional<Feed> findByIdAndWebsiteId(Long id, Long websiteId) {
    return feedRepository.findByIdAndWebsiteId(id, websiteId);
  }

  public void deleteByIdAndWebsiteId(Long id, Long websiteId) {
    feedRepository.deleteByIdAndWebsiteId(id, websiteId);
  }

  public void deleteAllByWebsiteId(Long websiteId) {
    feedRepository.deleteAllByWebsiteId(websiteId);
  }

  public void deleteAll() {
    feedRepository.deleteAll();
  }
}