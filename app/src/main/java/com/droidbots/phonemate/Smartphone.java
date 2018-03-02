package com.droidbots.phonemate;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by sabari on 5/2/18.
 */

public class Smartphone implements Serializable {
    @SerializedName("Imgsrc")
    @Expose
    private String encodedImage;
    @SerializedName("Name")
    @Expose
    private String deviceName;
    @SerializedName("Cost")
    @Expose
    private String price;
//    private HashMap<String, String> specs;

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Smartphone() {
//        specs = new HashMap<>();
    }

    public String getImage() {
        return encodedImage;
    }

    public void setImage(String base64Image) {
        this.encodedImage = base64Image;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

//    public HashMap<String, String> getSpecs() {
//        return specs;
//    }
//
//    public void addSpec(String specName, String spec) {
//        specs.put(specName, spec);
//    }
}
