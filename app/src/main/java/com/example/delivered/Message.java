package com.example.delivered;

import android.graphics.drawable.Drawable;

public class Message {
    private String deviceName;
    private String time;
    private String contentId;
    private Drawable imageDrawable;
    private Drawable backGroundDrawable;

    public Message(String deviceName, String time, String contentId, Drawable imageDrawable, Drawable backGroundDrawable){
        this.deviceName = deviceName;
        this.time = time;
        this.contentId = contentId;
        this.imageDrawable = imageDrawable;
        this.backGroundDrawable = backGroundDrawable;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setImageDrawable(Drawable imageDrawable) {
        this.imageDrawable = imageDrawable;
    }

    public Drawable getImageDrawable() {
        return imageDrawable;
    }

    public void setBackGroundDrawable(Drawable backGroundDrawable) {
        this.backGroundDrawable = backGroundDrawable;
    }

    public Drawable getBackGroundDrawable() {
        return backGroundDrawable;
    }
}
