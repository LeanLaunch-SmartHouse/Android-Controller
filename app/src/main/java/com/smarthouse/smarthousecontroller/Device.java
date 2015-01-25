package com.smarthouse.smarthousecontroller;

import android.graphics.drawable.Drawable;

/**
 * Created by Jordan on 25/01/2015.
 */
public class Device {
    public enum DeviceTypes { Unknown, Camera, Light, Thermometer, SmokeAlarm };

    DeviceTypes type;
    String name;
    Drawable icon;

    Device(DeviceTypes dt) {
        type = dt;
        name = dt.name();
    }

    Device() {
        this(DeviceTypes.Unknown);
    }

    public String toString() {
        return type.toString();
    }
}
