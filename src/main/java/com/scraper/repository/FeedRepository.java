package com.scraper.repository;

import com.scraper.model.domain.Feed;
import com.scraper.model.domain.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

public interface FeedRepository extends JpaRepository<Feed, Long> {
  List<Feed> findAllByWebsiteId(Long websiteId);

  Optional<Feed> findById(Long id);

  Optional<Feed> findByIdAndWebsiteId(Long id, Long websiteId);

  void deleteByIdAndWebsiteId(Long id, Long websiteId);

  void deleteById(Long id);

  List<Feed> findAll();

  void deleteAllByWebsiteId(Long websiteId);

  @Transactional
  @Query(value = "SELECT * FROM feed f left join website w on (f.website_id = w.id) where w.parent_id = ?1", nativeQuery = true)
  List<Feed> findAllByParentId(Long parentId);
}