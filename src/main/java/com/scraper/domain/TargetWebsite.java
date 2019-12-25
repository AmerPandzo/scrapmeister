package com.scraper.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * TargetWebsite class.
 */
@Entity
public class TargetWebsite {

  @Id
  @GeneratedValue
  private Long id;
  private String url;
  private LocalDateTime createdAt;

  @OneToOne
  private EntryParseRule entryParseRule;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public EntryParseRule getEntryParseRule() {
    return entryParseRule;
  }

  public void setEntryParseRule(EntryParseRule entryParseRule) {
    this.entryParseRule = entryParseRule;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
}