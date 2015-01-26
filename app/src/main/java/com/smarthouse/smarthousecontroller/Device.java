package com.smarthouse.smarthousecontroller;

/**
 * Created by Jordan on 25/01/2015.
 */

public class Device {
    public enum DeviceTypes { Unknown, Camera, Light, Thermometer, SmokeAlarm };

    private DeviceTypes type;
    private String name;
    private int iconID;

    Device(DeviceTypes dt, String name, int icon) {
        this.type = dt;
        this.name = name;
        this.iconID = icon;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int ic) {
        this.iconID = ic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceTypes getType() {
        return type;
    }

    public void setType(DeviceTypes dt) {
        this.type = dt;
    }

    @Override
    public String toString() {
        return name + "\n" + type.toString();
    }
}
