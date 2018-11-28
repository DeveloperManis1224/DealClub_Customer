package com.app.android.deal.dealclub.Data;

public class LoginResponse {


    private String message;
    private String status;

    public LoginResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }


    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

}
