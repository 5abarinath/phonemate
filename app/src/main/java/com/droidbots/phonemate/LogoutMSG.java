package com.droidbots.phonemate;

/**
 * Created by vishvanatarajan on 11/3/18.
 */

public class LogoutMSG {
    private String status;
    private String message;

    public LogoutMSG(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
