package com.scraper.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * TargetWebsite class.
 */
@Entity
public class TargetWebsite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String url;
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private TargetWebsite parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<TargetWebsite> children;

    @OneToOne(cascade = CascadeType.ALL)

    @JoinColumn(name = "entry_parse_rule_id", referencedColumnName = "id")
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

  public TargetWebsite getParent() {
    return parent;
  }

  public void setParent(TargetWebsite parent) {
    this.parent = parent;
  }

  public Collection<TargetWebsite> getChildren() {
    return children;
  }

  public void setChildren(Collection<TargetWebsite> children) {
    this.children = children;
  }
}