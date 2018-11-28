package com.app.android.deal.dealclub.Data;

public class RegistrationResponse {

    private String timestamp;
    private String status;
    private String error;
    private String message;

    public RegistrationResponse(String timestamp, String status, String error, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
