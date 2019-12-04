package br.com.juno.integration.api.base.exception;

import kong.unirest.UnirestException;

public class JunoApiException extends UnirestException {

    private static final long serialVersionUID = -3935323981105727201L;

    public JunoApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public JunoApiException(ErrorDetail errorDetail) {
        super(errorDetail != null ? errorDetail.toString() : null);
    }

    public JunoApiException(String message) {
        super(message);
    }

    public JunoApiException(Throwable cause) {
        super(cause);
    }

}
