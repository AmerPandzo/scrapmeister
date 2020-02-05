package com.scraper.service.error;

import static java.util.Arrays.asList;

import com.scraper.model.response.ErrorResponse;
import com.scraper.model.response.Message;
import com.scraper.model.response.MessageDetail;
import com.scraper.model.response.MessageTitle;
import com.scraper.model.response.Severity;
import org.springframework.stereotype.Component;


/**
 * This class mimics the builder pattern, and encapsulates the complexity
 * involved in creating a new ErrorResponse object.
 */
@Component
public class ErrorResponseBuilder extends ErrorResponseBuilderBase {

  public ErrorResponse build(final Error error, final Error.Source source, final String... params) {
    final MessageTitle messageTitle = new MessageTitle(error.titleKey(), error.defaultTitle());
    final MessageDetail messageDetail = new MessageDetail(error.messageKey(), error.defaultMessage());
    if (params != null) {
      messageDetail.setParams(asList(params));
      messageDetail.setText(String.format(error.defaultMessage(), (Object[]) params));
    }
    final ErrorResponse errorResponse = super.build(source.value());
    errorResponse.addMessage(new Message(Severity.ERROR, error.code(), messageTitle, messageDetail));
    return errorResponse;
  }
}
