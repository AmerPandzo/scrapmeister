package com.scraper.repository;

import com.scraper.domain.FeedEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedEntryRepository extends JpaRepository<FeedEntry, Long> {
  List<FeedEntry> findAllByTargetWebsiteId(Long targetWebsiteId);

  List<FeedEntry> findAll();

  void deleteAllByTargetWebsiteId(Long targetWebsiteId);
}