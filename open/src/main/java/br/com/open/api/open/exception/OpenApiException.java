package br.com.open.api.open.exception;

import java.util.Date;

public class OpenApiException extends RuntimeException {

    private OpenStatusFactory openStatusFactory;

    public OpenApiException(OpenStatusFactory openStatusFactory) {
        getFormat();
        this.openStatusFactory = openStatusFactory;
    }

    public OpenApiException(String message) {
        super(message);
    }

    public OpenApiException(String message, Throwable ex) {
        super(message, ex);
    }

    public OpenStatusFactory getOpenStatusFactory() {
        return this.openStatusFactory;
    }

    public void setOpenStatusFactory(OpenStatusFactory openStatusFactory) {
        this.openStatusFactory = openStatusFactory;
    }

    private String getFormat() {
        return String.format("Uma Exceção foi lançada em ".concat(" - ").concat(new Date().toString()));
    }
}
