package com.scraper.model.response;

import java.time.LocalDateTime;

public class PlainFeedResponse {
  private String title;
  private String author;
  private String content;
  private String url;
  private String imageUrl;
  private LocalDateTime cratedAt;

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(final String author) {
    this.author = author;
  }

  public String getContent() {
    return content;
  }

  public void setContent(final String content) {
    this.content = content;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(final String url) {
    this.url = url;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(final String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public LocalDateTime getCratedAt() {
    return cratedAt;
  }

  public void setCratedAt(final LocalDateTime cratedAt) {
    this.cratedAt = cratedAt;
  }
}
