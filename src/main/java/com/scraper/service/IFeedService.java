package com.scraper.service;

import com.scraper.model.domain.Feed;

import java.util.List;
import java.util.Optional;

public interface IFeedService {
  Feed save(Feed feed);

  List<Feed> findAll();

  List<Feed> findAllByWebsiteId(Long websiteId);

  Optional<Feed> findByIdAndWebsiteId(Long id, Long websiteId);

  void deleteByIdAndWebsiteId(Long id, Long websiteId);

  void deleteAllByWebsiteId(Long websiteId);

  void deleteAll();
}
