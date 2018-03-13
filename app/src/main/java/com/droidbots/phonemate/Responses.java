package com.droidbots.phonemate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by sabari on 13/3/18.
 */

public class Responses implements Serializable {

    @SerializedName("smartphone")
    @Expose
    private String smartphone;
    @SerializedName("os")
    @Expose
    private String os;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("busage")
    @Expose
    private String busage;
    @SerializedName("battery")
    @Expose
    private String battery;
    @SerializedName("storage")
    @Expose
    private String storage;
    @SerializedName("camera")
    @Expose
    private String camera;
    @SerializedName("screen")
    @Expose
    private String screen;
    @SerializedName("ram")
    @Expose
    private String ram;
    @SerializedName("weight")
    @Expose
    private String weight;

    public Responses(String smartphone, String os, String price, String busage, String battery,
                     String storage, String camera, String screen, String ram, String weight) {
        this.smartphone = smartphone;
        this.os = os;
        this.price = price;
        this.busage = busage;
        this.battery = battery;
        this.storage = storage;
        this.camera = camera;
        this.screen = screen;
        this.ram = ram;
        this.weight = weight;
    }

    public String getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(String smartphone) {
        this.smartphone = smartphone;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBusage() {
        return busage;
    }

    public void setBusage(String busage) {
        this.busage = busage;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
