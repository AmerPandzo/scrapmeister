package com.scraper.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rule")
public class Rule {

  @Id
  @GeneratedValue
  private Long id;
  private String newsContainer;
  private String title;
  private String content;
  private String link;
  private LocalDateTime cratedAt;

  @ManyToMany(fetch = FetchType.LAZY,
      cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
      },
      mappedBy = "rules")
  @JsonBackReference
  private List<Website> websites = new ArrayList<>();

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

  public List<Website> getWebsites() {
    return websites;
  }

  public void setWebsites(final List<Website> websites) {
    this.websites = websites;
  }
}
