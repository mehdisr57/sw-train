package com.msrazavi.train.sw.err;

public class ResponseError {
    private String message;
    private String status;

    public ResponseError() {
    }

    public ResponseError(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
