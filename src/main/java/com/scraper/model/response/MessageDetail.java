package com.scraper.model.response;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * This class represents the error message detail.
 */
@JsonInclude(NON_EMPTY)
public class MessageDetail implements Serializable {

  private String text;
  private String key;
  private List<String> params;

  public MessageDetail() {
  }

  public MessageDetail(final String key, final String text) {
    this.key = key;
    this.text = text;
  }

  @JsonProperty("text")
  public String getText() {
    return text;
  }

  public void setText(final String text) {
    this.text = text;
  }

  @JsonProperty("key")
  public String getKey() {
    return key;
  }

  public void setKey(final String key) {
    this.key = key;
  }

  @JsonProperty("params")
  public List<String> getParams() {
    return params;
  }

  public void setParams(final List<String> params) {
    this.params = params;
  }

  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }

    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    final MessageDetail that = (MessageDetail) object;

    return new EqualsBuilder()
        .append(text, that.text)
        .append(key, that.key)
        .append(params, that.params)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(text)
        .append(key)
        .append(params)
        .toHashCode();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("class MessageDetail {\n");
    builder.append("  text: ").append(text).append("\n");
    builder.append("  key: ").append(key).append("\n");
    builder.append("  params: ").append(params).append("\n");
    builder.append("}\n");
    return builder.toString();
  }
}
