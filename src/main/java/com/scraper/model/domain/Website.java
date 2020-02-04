package com.scraper.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Website class.
 */
@Entity
@Table(name = "website")
public class Website implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String url;

  private LocalDateTime createdAt;

  @Column(name = "update_at")
  private LocalDateTime updatedAt;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JsonBackReference
  private Website parent;

  @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JsonManagedReference
  private Collection<Website> children;

  @ManyToMany(fetch = FetchType.LAZY,
      cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
      })
  @JoinTable(name = "web" +
      "site_rule",
      joinColumns = {@JoinColumn(name = "website_id")},
      inverseJoinColumns = {@JoinColumn(name = "rule_id")})
  private Set<Rule> rules = new HashSet<>();

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

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Website getParent() {
    return parent;
  }

  public void setParent(Website parent) {
    this.parent = parent;
  }

  public Collection<Website> getChildren() {
    return children;
  }

  public void setChildren(Collection<Website> children) {
    this.children = children;
  }

  public Set<Rule> getRules() {
    return rules;
  }

  public void setRules(final Set<Rule> rules) {
    this.rules = rules;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public static final class WebsiteBuilder {
    private Long id;
    private String url;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Website parent;
    private Collection<Website> children;
    private Set<Rule> rules = new HashSet<>();

    private WebsiteBuilder() {
    }

    public static WebsiteBuilder aWebsite() {
      return new WebsiteBuilder();
    }

    public WebsiteBuilder setId(Long id) {
      this.id = id;
      return this;
    }

    public WebsiteBuilder setUrl(String url) {
      this.url = url;
      return this;
    }

    public WebsiteBuilder setCreatedAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public WebsiteBuilder setUpdatedAt(LocalDateTime updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public WebsiteBuilder setParent(Website parent) {
      this.parent = parent;
      return this;
    }

    public WebsiteBuilder setChildren(Collection<Website> children) {
      this.children = children;
      return this;
    }

    public WebsiteBuilder setRules(Set<Rule> rules) {
      this.rules = rules;
      return this;
    }

    public Website build() {
      Website website = new Website();
      website.setId(id);
      website.setUrl(url);
      website.setCreatedAt(createdAt);
      website.setUpdatedAt(updatedAt);
      website.setParent(parent);
      website.setChildren(children);
      website.setRules(rules);
      return website;
    }
  }

}