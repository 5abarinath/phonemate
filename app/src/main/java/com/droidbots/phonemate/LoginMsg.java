package com.droidbots.phonemate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vishvanatarajan on 8/2/18.
 */

public class LoginMsg {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String msg;
    @SerializedName("token")
    @Expose
    private String token;

    public LoginMsg(String status, String msg, String token) {
        this.status = status;
        this.msg = msg;
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() { return token; }

    public void setToken(String token) { this.token = token; }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
