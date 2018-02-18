package com.droidbots.phonemate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vishvanatarajan on 8/2/18.
 */

public class LoginMsg {
    @SerializedName("reply")
    @Expose
    private boolean reply;
    @SerializedName("msg")
    @Expose
    private String msg;

    public LoginMsg(boolean reply, String msg) {
        this.reply = reply;
        this.msg = msg;
    }

    public boolean getReply() {
        return reply;
    }

    public void setReply(boolean reply) {
        this.reply = reply;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
