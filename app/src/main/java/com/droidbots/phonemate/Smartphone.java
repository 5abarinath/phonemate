package com.droidbots.phonemate;

import android.graphics.drawable.Drawable;

/**
 * Created by sabari on 5/2/18.
 */

public class Smartphone {
    private Drawable thumbnail;
    private String deviceName, price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Smartphone() {
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
