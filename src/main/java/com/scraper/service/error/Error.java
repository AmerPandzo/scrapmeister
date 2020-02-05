package com.scraper.service.error;

/**
 * Enum for error responses.They can be originated by the application's code
 * or by external applications(when consuming external services).
 */
public enum Error {

  SOMETHING_WRONG("001", "common.error.header.5XX", "common.error.text.5XX",
      "Oops! Something went wrong.",
      "Wrong method was used to view this page."),
  CONTENT_FORBIDDEN("002", "common.error.header.4XX", "common.error.text.4XX",
      "Oops! Content Forbidden from being accessed.",
      "You do not have permission to view this page."),
  SESSION_TIMEOUT("003", "module.session.text.expired_heading", "module.session.text.expired_desc",
      "Oops! Your session has expired",
      "You have exceeded the maximum time allowed to complete your transaction. Please try again."),
  UNSUPPORTED_OPERATION("004", "operation.not.supported.title", "operation.not.supported.detail",
      "Operation not supported.",
      "This operation is not supported by PSP."),
  INVALID_SHA1HASH("005", "sha1hash.not.valid.title", "sha1hash.not.valid.title", "Hash not valid",
      "Sha1Hash is not valid, empty or null"),
  INPUT_UNSUPPORTED_MEDIA_TYPE("010", "input.media_type.unsupported.title",
      "input.media_type.unsupported.detail", "Unsupported media type.", "Content type not supported"),
  INPUT_INVALID("011", "input.invalid.title", "input.invalid.detail",
      "Input not valid.", "Input not valid: %s"),
  INVALID_X_TOKEN("012", "x.token.invalid.title", "x.token.invalid.detail",
      "X-Token not valid.", "X-Token not valid:  %s."),
  X_TOKEN_NOT_FOUND("013", "x.token.missing.title", "x.token.missing.detail",
      "Missing X-Token", "The X-Token header is not present."),
  INVALID_CHANNEL_TYPE("014", "invalid.channel.type.title", "invalid.channel.type.detail",
      "ChannelType not valid.", "ChannelType not valid: %s"),
  INVALID_PAYMENT_METHOD("014", "invalid.payment.method.title", "invalid.payment.method.detail",
      "Payment method not valid.", "Payment method is not valid: %s"),
  NOTIFICATION_URL_JWT_TOKEN_NOT_FOUND("040", "notification.url.jwt.token.missing.title",
      "notification.url.jwt.token.missing.detail", "Missing JWT Token in notification URL",
      "Received invalid method_notification_url. JWT Token is missing."),
  NOTIFICATION_URL_INVALID_JWT_TOKEN("041", "notification.url.jwt.token.invalid.title",
      "notification.url.jwt.token.invalid.detail", "Failed JWT Token validation",
      "Validation of JWT Token from method_notification_url failed: %s."),
  PAYMENT_DETAIL_NOT_FOUND("050", "payment.state.not_found.title", "payment.state.not_found.detail",
      "Payment detail missing.", "Cannot process payment. Payment detail state or status missing."),
  PAYMENT_DETAIL_STATE_INVALID("051", "payment.state.invalid.title", "payment.state.invalid.detail",
      "Invalid payment state.", "Cannot process payment while payment in state %s with status %s."),
  PAYMENT_AUTHORISE_NOT_FOUND("052", "payment.authorise.not_found.title", "payment.authorise.not_found.detail",
      "Authorise not found.", "Cannot process payment. Missing successful authorise transaction from PSP."),
  PAYMENT_CAPTURE_BIGGER_THAN_AUTHORISED("053", "payment.capture.amount_bigger_than_authorised.title",
      "payment.capture.amount_bigger_than_authorised.detail", "Capture amount bigger than authorised.",
      "Cannot capture payment. Capturing amount bigger than authorized."),
  PAYMENT_REFUND_BIGGER_THAN_AUTHORISED("054", "payment.refund.amount_bigger_than_authorised.title",
      "payment.refund.amount_bigger_than_authorised.detail", "Refund amount bigger than authorised.",
      "Cannot refund payment. Refunding amount bigger than authorized."),
  PAYMENT_CAPTURE_CURRENCY_NOT_EQUAL_AUTHORISED("055", "payment.capture.currency_not_equal_to_authorised.title",
      "payment.capture.currency_not_equal_to_authorised.detail", "Capture currency not equal to authorised currency.",
      "Cannot capture payment. Capture currency not equal to authorised currency."),
  PAYMENT_CAPTURE_AMOUNT_NOT_EQUAL_CREATED("056", "payment.capture.amount_not_equal_to_created.title",
      "payment.capture.amount_not_equal_to_created.detail", "Capture amount not equal to created amount.",
      "Cannot capture payment. Capture amount not equal to created amount."),
  PAYMENT_CAPTURE_CURRENCY_NOT_EQUAL_CREATED("057", "payment.capture.currency_not_equal_to_created.title",
      "payment.capture.currency_not_equal_to_created.detail", "Capture currency not equal to created currency.",
      "Cannot capture payment. Capture currency not equal to created currency."),
  PAYMENT_CAPTURE_NOT_FOUND("058", "payment.capture.not_found.title", "payment.capture.not_found.detail",
      "Capture not found.", "Cannot process payment. Missing successful capture transaction from PSP."),
  PAYMENT_TOTAL_REFUND_BIGGER_THAN_ORIGINAL("059", "payment.refund.amount_total_bigger_than_original.title",
      "payment.refund.amount_total_bigger_than_original.detail", "Refund total amount bigger than original.",
      "Cannot refund payment. Refunding total amount bigger than original."),
  PAYMENT_TOTAL_LOYALTY_POINTS_BIGGER_THAN_MAX("060", "payment.refund.amount_total_loyalty_points_bigger_than_max.title",
      "payment.refund.amount_total_loyalty_points_bigger_than_max.detail", "Refund total loyalty pints bigger than max.",
      "Cannot refund payment. Refunding total loyalty points bigger than maximum."),
  PAYMENT_REFUND_CURRENCY_NOT_EQUAL_AUTHORISED("062", "payment.refund.currency_not_equal_to_authorised.title",
      "payment.refund.currency_not_equal_to_authorised.detail", "Refund currency not equal to authorised currency.",
      "Cannot refund payment. Refund currency not equal to authorised currency."),
  PAYMENT_ALREADY_CAPTURED("063", "payment.captured.cancel_not_possible.title",
      "payment.captured.cancel_not_possible.detail", "Can't void settled transaction.",
      "Cannot cancel payment which has already been captured/settled."),
  PAYMENT_TRANSACTION_ID_ALREADY_EXISTS("064", "payment.transaction_id_already_exists.title",
      "payment.transaction_id_already_exists.detail", "Transaction id already exists.",
      "Cannot process payment. Afop transaction id already exists."),
  PSP_CONFIGURATION_MISSING("100", "psp.configuration.missing.title", "psp.configuration.missing.detail",
      "PSP configuration is missing.", "Cannot process payment. PSP configuration is missing."),
  PSP_CONFIGURATION_INVALID("101", "psp.configuration.invalid.title", "psp.configuration.invalid.detail",
      "PSP configuration is invalid.", "Cannot process payment. PSP configuration is invalid."),
  PSP_CONNECTION_UNAVAILABLE("102", "psp.connection.unavailable.title", "psp.connection.unavailable.detail",
      "PSP connection is currently unavailable.", "Cannot process payment. PSP connection is unavailable."),
  PAYMENT_CARD_NUMBER_INVALID("300", "payment.card.number.invalid",
      "phub.userData.invalid.card", "Card number is invalid",
      "Card Number is invalid."),
  PAYMENT_CARD_YEAR_INVALID_LENGTH("301", "payment.card.year.length.invalid",
      "phub.userData.yearLength.invalid", "Card Expiration Year is invalid.",
      "Card expiration year must be four digits long."),
  PAYMENT_CARD_EXPIRATION_YEAR_INVALID("302", "payment.card.year.length.invalid",
      "phub.userData.year.invalid", "Card Expiration Year is invalid.",
      "Card expiration year is invalid."),
  PAYMENT_CARD_DATE_PAST("303", "payment.card.date.past.invalid",
      "phub.userData.paymentCard.date.past", "Card expiration is invalid.",
      "Card expiration date is in the past."),
  PAYMENT_CARD_EXPIRATION_MONTH_INVALID("304", "payment.card.expiration.month.invalid",
      "phub.userData.month.invalid", "Card Expiration Month is invalid.",
      "Card month is invalid."),
  PAYMENT_CARD_EXPIRATION_MONTH_YEAR_INVALID("305", "payment.card.expiration.month.year.invalid",
      "phub.userData.characters.valid.month.year", "Please enter a valid date in the format YYYYMM.",
      "Card Expiration Month and Year may only contain characters: 0-9."),
  PAYMENT_CARD_EXPIRATION_MONTH_YEAR_DAY_INVALID("305", "payment.card.expiration.month.year.day.invalid",
      "phub.userData.characters.valid.month.year.day", "Please enter a valid date in the format YYMMDD.",
      "Card Expiration Date is invalid."),
  PAYMENT_CARD_EXPIRATION_MONTH_YEAR_REQUIRED("306", "payment.card.expiration.month.year.invalid",
      "phub.userData.required.month.year", "Please enter a valid date in the format MM/YY.",
      "Card Expiration Month and Year is required."),
  PAYMENT_CARD_TYPE_TEXT_MISSING("307", "payment.card.type.invalid",
      "phub.userData.required.cardType", "Card type is invalid.",
      "Card Type is required."),
  PAYMENT_CARD_NUMBER_REQUIRED("308", "payment.card.number.invalid",
      "phub.userData.required.cardNumber", "Card number is invalid.",
      "Card Number is required."),
  PAYMENT_CARD_NUMBER_NOT_NUMERIC("309", "payment.card.number.invalid",
      "phub.userData.characters.valid.cardNumber", "Card number is invalid.",
      "Card Number may only contain characters: 0-9."),
  PAYMENT_CARD_NUMBER_LENGTH_LONGER("310", "payment.card.number.length.invalid",
      "phub.userData.maxLength.invalid.cardNumber", "Card number length is invalid.",
      "Card Number cannot exceed %s characters."),
  PAYMENT_CARD_NUMBER_LENGTH_INVALID("311", "payment.card.number.length.invalid",
      "phub.userData.invalid.length.cardNumber", "Card number length is invalid.",
      "Card Number length is invalid."),
  PAYMENT_CARD_CVV_MISSING("312", "payment.card.cvvnumber.invalid",
      "phub.userData.required.cvvNumber", "CVV is invalid.",
      "CVV Number is required."),
  PAYMENT_CARD_CVV_INVALID("313", "payment.card.cvvnumber.invalid",
      "phub.userData.characters.valid.cvvNumber", "CVV is invalid.",
      "CVV Number may only contain characters: 0-9."),
  PAYMENT_CARD_CVV_MIN_LENGTH_INVALID("314", "payment.card.cvvnumber.length.invalid",
      "phub.userData.minLength.contain.invalid.cvv", "CVV length is invalid.",
      "CVV number must contain at least %s characters."),
  PAYMENT_CARD_CVV_MAX_LENGTH_INVALID("315", "payment.card.cvvnumber.length.invalid",
      "phub.userData.maxLength.contain.invalid.cvv", "CVV length is invalid.",
      "CVV number cannot exceed %s characters."),
  PAYMENT_CARD_TYPE_NOT_SUPPORTED("316", "payment.card.cardType.not.found",
      "payment.card.cardType.not.found.detail", "Requested card type is not supported",
      "%s card type is not supported"),
  CARD_NUMBER_INVALID("1001", "tokenization.card.number.invalid.title", "tokenization.card.number.invalid.detail",
      "Card number invalid", "Requested PAN number for tokenization is not valid PAN number"),
  INVALID_BASE64_STRING("1002", "tokenization.base64.input.invalid.title", "tokenization.base64.input.invalid.detail",
      "Card number invalid", "%s invalid base64 string"),
  INVALID_INPUT_FOR_DECRYPTION("1003", "tokenization.decryption.input.invalid.title",
      "tokenization.decryption.input.invalid.detail",
      "Decryption failed", "Message is encrypted with wrong public key, or incorrectly padded or block size is too large"),
  CARD_NUMBER_INELIGIBLE("1004", "tokenization.card.number.ineligible.title", "tokenization.card.number.ineligible.detail",
      "Card number ineligible for PHUB processing", "%s is prepaid card number."),
  THREEDS_ALLREADY_AUTHENTICATED("1005", "threeds.authenticate.already.authenticated.title",
      "threeds.authenticate.already.authenticated.detail",
      "Already authenticated for 3DS2", "Transaction with paymentId: %s is already authenticated"),
  THREEDS_VESION_CHECK_NOT_PERFORMED("1006", "threeds.authenticate.version.check.not.performed.title",
      "threeds.authenticate.version.check.not.performed.title",
      "Version check is not performed", "Version check is not performed for transaction with paymentId: %s"),
  THREEDS_NOT_ENROLLED("1007", "threeds.authenticate.not.enrolled.title", "threeds.authenticate.not.enrolled.detail",
      "Not enrolled for 3DS2", "Transaction with paymentId: %s is not enrolled for 3DS2"),
  HSM_ERROR("2000", "tokenization.hsm.error.title", "tokenization.hsm.error..title.detail",
      "There is issue with HSM connection", "HSM error"),
  SUB_ACCOUNT_CONFIGURATION_MISSING("3000", "subaccount.configuration.missing.title", "sub_account.configuration.missing.message",
      "Sub Account configuration missing ", " Sub Account configuration is missing or invalid "),
  PAYMENT_METHOD_DCC_NOT_SUPPORTED("2002", "payment.method.dcc.not.supported.title", "payment.method.dcc.not.supported.detail",
      "Payment method not supported ", "DCC is not supported with payment method %s"),
  PAYMENT_ID_NOT_FOUND_IN_DATABASE("4000", "payment.id.not.found.in.database.title", "payment.id.not.found.in.database.detail",
      "Provided payment ID is invalid ", "Provided payment ID does not exist in database"),
  DATABASE_CALL_FAILED("4001", "database.call.failed.title", "database.call.failed.detail",
      "Database call failed ", "Stored procedure call failed"),
  DATABASE_RULE_VIOLATION("4002", "database.rule.validation.title", "database.rule.validation.detail",
      "Database rule violated", "Sql error code: %s, Error message: %s "),
  PSP_DCC_RATE_CHANGED("5000", "dcc.rate.changed.title", "dcc.rate.changed.detail",
      "PSP DCC call returned different rate than initial call.", "Initial DCC rate: %s, current DCC rate: %s");

  private String code;
  private String titleKey;
  private String messageKey;
  private String defaultTitle;
  private String defaultMessage;

  Error(final String code, final String titleKey, final String messageKey, final String defaultTitle,
      final String defaultMessage) {
    this.code = code;
    this.titleKey = titleKey;
    this.messageKey = messageKey;
    this.defaultTitle = defaultTitle;
    this.defaultMessage = defaultMessage;
  }

  public String code() {
    return code;
  }

  public String titleKey() {
    return titleKey;
  }

  public String messageKey() {
    return messageKey;
  }

  public String defaultTitle() {
    return defaultTitle;
  }

  public String defaultMessage() {
    return defaultMessage;
  }

  /**
   * Encapsulates the source end point for this default error.
   */
  public enum Source {
    PAYMENTS("/payments"),
    TOKENS("/tokens");

    private String value;

    Source(final String value) {
      this.value = value;
    }

    public String value() {
      return value;
    }
  }
}
