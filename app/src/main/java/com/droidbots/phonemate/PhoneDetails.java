package com.droidbots.phonemate;

import android.graphics.drawable.Drawable;

/**
 * Created by sabari on 5/2/18.
 */

public class PhoneDetails {
    private Drawable thumbnail;
    private String deviceName;

    public PhoneDetails() {
    }

    public Drawable getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Drawable thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
