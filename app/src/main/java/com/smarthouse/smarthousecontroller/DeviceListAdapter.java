package com.smarthouse.smarthousecontroller;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jordan on 26/01/2015.
 */
public class DeviceListAdapter extends BaseAdapter {
    Context context;
    List<Device> rowItems;

    public DeviceListAdapter(Context cx, List<Device> items) {
        this.context = cx;
        this.rowItems = items;
    }

    // private view holder class
    private class ViewHolder {
        ImageView imageView;
        TextView txName;
        TextView txType;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflator = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = mInflator.inflate(R.layout.row, null);
            holder = new ViewHolder();
            holder.txName = (TextView) convertView.findViewById(R.id.name);
            holder.txType = (TextView) convertView.findViewById(R.id.type);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Device rowItem = (Device) getItem(position);
        holder.txName.setText(rowItem.getName());
        holder.txType.setText(rowItem.getType().toString());
        holder.imageView.setImageResource(rowItem.getIconID());

        return convertView;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int p) {
        return rowItems.get(p);
    }

    @Override
    public long getItemId(int pos) {
        return rowItems.indexOf(getItem(pos));
    }
}
