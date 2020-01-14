package com.scraper.repository;

import com.scraper.domain.FeedEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FeedEntryRepository extends JpaRepository<FeedEntry, Long> {
  List<FeedEntry> findAllByTargetWebsiteId(Long targetWebsiteId);

  Optional<FeedEntry> findById(Long id);

  Optional<FeedEntry> findByIdAndTargetWebsiteId(Long id, Long targetWebsiteId);

  void deleteByIdAndTargetWebsiteId(Long id, Long targetWebsiteId);

  void deleteById(Long id);

  List<FeedEntry> findAll();

  void deleteAllByTargetWebsiteId(Long targetWebsiteId);
}