package com.scraper.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
  private List<Rule> rules = new ArrayList<>();

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

  public List<Rule> getRules() {
    return rules;
  }

  public void setRules(final List<Rule> rules) {
    this.rules = rules;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}