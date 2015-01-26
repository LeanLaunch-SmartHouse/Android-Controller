package com.smarthouse.smarthousecontroller;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeviceList extends ActionBarActivity implements OnItemClickListener {

    public enum DeviceTypes { Camera, Light, Thermometer, SmokeAlarm }
    ArrayList<Device> deviceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);

        Device dl[] = new Device[] {
                new Device(Device.DeviceTypes.Light, "Light bulb 01", R.drawable.ic_light_bulb_icon),
                new Device(Device.DeviceTypes.Light, "Light bulb 02", R.drawable.ic_light_bulb_icon),
                new Device(Device.DeviceTypes.Light, "Light bulb 03", R.drawable.ic_light_bulb_icon),
                new Device(Device.DeviceTypes.Thermometer, "Thermometer 01", R.drawable.ic_thermometer),
        };

        deviceList = new ArrayList<>();
        for (int i = 0; i < dl.length; i++) {
            deviceList.add(dl[i]);
        }

        ListView lv = (ListView) findViewById(R.id.deviceListCtl);

        DeviceListAdapter adapter = new DeviceListAdapter(this, deviceList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        Log.d("List","Populated");
        Toast toast = Toast.makeText(getApplicationContext(), "blah", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_device_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
