package com.scraper.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EntryParseRule {

  @Id
  @GeneratedValue
  private Long id;
  private String newsContainer;
  private String title;
  private String content;
  private String link;
  private LocalDateTime cratedAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNewsContainer() {
    return newsContainer;
  }

  public void setNewsContainer(String newsContainer) {
    this.newsContainer = newsContainer;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public LocalDateTime getCratedAt() {
    return cratedAt;
  }

  public void setCratedAt(LocalDateTime cratedAt) {
    this.cratedAt = cratedAt;
  }
}
