package com.scraper.repository;

import com.scraper.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FeedRepository extends JpaRepository<Feed, Long> {
  List<Feed> findAllByWebsiteId(Long websiteId);

  Optional<Feed> findById(Long id);

  Optional<Feed> findByIdAndWebsiteId(Long id, Long websiteId);

  void deleteByIdAndWebsiteId(Long id, Long websiteId);

  void deleteById(Long id);

  List<Feed> findAll();

  void deleteAllByWebsiteId(Long websiteId);
}