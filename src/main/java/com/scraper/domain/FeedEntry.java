package com.scraper.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FeedEntry {

  @Id
  @GeneratedValue
  private Long id;
  private String title;
  private String author;
  @Column(columnDefinition = "TEXT")
  private String content;
  private String url;
  private String imageUrl;
  @ManyToOne
  @JoinColumn(name = "target_website_id")
  private TargetWebsite targetWebsite;

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

  public TargetWebsite getTargetWebsite() {
    return targetWebsite;
  }

  public void setTargetWebsite(TargetWebsite targetWebsite) {
    this.targetWebsite = targetWebsite;
  }

  public static final class FeedEntryBuilder {
    private Long id;
    private String title;
    private String author;
    private String content;
    private String url;
    private String imageUrl;
    private TargetWebsite targetWebsite;

    private FeedEntryBuilder() {
    }

    public static FeedEntryBuilder aFeedEntry() {
      return new FeedEntryBuilder();
    }

    public FeedEntryBuilder setId(Long id) {
      this.id = id;
      return this;
    }

    public FeedEntryBuilder setTitle(String title) {
      this.title = title;
      return this;
    }

    public FeedEntryBuilder setAuthor(String author) {
      this.author = author;
      return this;
    }

    public FeedEntryBuilder setContent(String content) {
      this.content = content;
      return this;
    }

    public FeedEntryBuilder setUrl(String url) {
      this.url = url;
      return this;
    }

    public FeedEntryBuilder setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
      return this;
    }

    public FeedEntryBuilder setTargetWebsite(TargetWebsite targetWebsite) {
      this.targetWebsite = targetWebsite;
      return this;
    }

    public FeedEntry build() {
      FeedEntry feedEntry = new FeedEntry();
      feedEntry.setId(id);
      feedEntry.setTitle(title);
      feedEntry.setAuthor(author);
      feedEntry.setContent(content);
      feedEntry.setUrl(url);
      feedEntry.setImageUrl(imageUrl);
      feedEntry.setTargetWebsite(targetWebsite);
      return feedEntry;
    }
  }
}