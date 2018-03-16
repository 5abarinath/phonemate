package com.droidbots.phonemate;

/**
 * Created by vishvanatarajan on 16/3/18.
 */

public class ProfileMsg {
    private String status;
    private String message;

    public ProfileMsg(String status, String message) {
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
