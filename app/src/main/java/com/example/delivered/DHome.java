package com.example.delivered;

public class DHome {
    private String deviceName;
    private String ID;

    public DHome(String deviceName, String ID){
        this.deviceName = deviceName;
        this.ID = ID;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getID() {
        return ID;
    }
}
