package com.scraper.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * This class represents the error message title.
 */
public class MessageTitle implements Serializable {

  private String text;
  private String key;

  public MessageTitle() {
  }

  public MessageTitle(final String key, final String text) {
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

  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }

    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    final MessageTitle that = (MessageTitle) object;

    return new EqualsBuilder()
        .append(text, that.text)
        .append(key, that.key)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(text)
        .append(key)
        .toHashCode();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("class MessageTitle {\n");
    builder.append("  text: ").append(text).append("\n");
    builder.append("  key: ").append(key).append("\n");
    builder.append("}\n");
    return builder.toString();
  }
}
