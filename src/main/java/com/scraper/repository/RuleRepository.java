package com.scraper.repository;

import com.scraper.model.domain.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.transaction.Transactional;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {

  @Transactional
  @Query(value = "select * from rule r join website_rule wr on (r.id = wr.rule_id) join website w on (wr.website_id = w.id) where w.id = ?1", nativeQuery = true)
  List<Rule> findByWebsiteId(Long websiteId);
}

