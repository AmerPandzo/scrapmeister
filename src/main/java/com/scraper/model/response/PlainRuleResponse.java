package com.scraper.model.response;

import java.time.LocalDateTime;

public class PlainRuleResponse {
  private String newsContainer;
  private String title;
  private String content;
  private String link;
  private LocalDateTime cratedAt;

  public String getNewsContainer() {
    return newsContainer;
  }

  public void setNewsContainer(final String newsContainer) {
    this.newsContainer = newsContainer;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(final String content) {
    this.content = content;
  }

  public String getLink() {
    return link;
  }

  public void setLink(final String link) {
    this.link = link;
  }

  public LocalDateTime getCratedAt() {
    return cratedAt;
  }

  public void setCratedAt(final LocalDateTime cratedAt) {
    this.cratedAt = cratedAt;
  }
}
