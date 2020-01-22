package com.scraper.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feed")
public class Feed {

  @Id
  @GeneratedValue
  private Long id;
  private String title;
  private String author;
  @Column(columnDefinition = "TEXT")
  private String content;
  private String url;
  private String imageUrl;
  private LocalDateTime cratedAt;
  @ManyToOne
  @JoinColumn(name = "website_id")
  private Website website;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Website getWebsite() {
    return website;
  }

  public void setWebsite(Website website) {
    this.website = website;
  }

  public LocalDateTime getCratedAt() {
    return cratedAt;
  }

  public void setCratedAt(LocalDateTime cratedAt) {
    this.cratedAt = cratedAt;
  }

  public static final class FeedBuilder {
    private Long id;
    private String title;
    private String author;
    private String content;
    private String url;
    private String imageUrl;
    private Website website;
    private LocalDateTime createdAt;

    private FeedBuilder() {
    }

    public static FeedBuilder aFeed() {
      return new FeedBuilder();
    }

    public FeedBuilder setId(Long id) {
      this.id = id;
      return this;
    }

    public FeedBuilder setTitle(String title) {
      this.title = title;
      return this;
    }

    public FeedBuilder setAuthor(String author) {
      this.author = author;
      return this;
    }

    public FeedBuilder setContent(String content) {
      this.content = content;
      return this;
    }

    public FeedBuilder setUrl(String url) {
      this.url = url;
      return this;
    }

    public FeedBuilder setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
      return this;
    }

    public FeedBuilder setWebsite(Website website) {
      this.website = website;
      return this;
    }

    public FeedBuilder setCratedAt(LocalDateTime cratedAt) {
      this.createdAt = cratedAt;
      return this;
    }

    public Feed build() {
      Feed feed = new Feed();
      feed.setId(id);
      feed.setTitle(title);
      feed.setAuthor(author);
      feed.setContent(content);
      feed.setUrl(url);
      feed.setImageUrl(imageUrl);
      feed.setWebsite(website);
      feed.setCratedAt(createdAt);
      return feed;
    }
  }
}