package com.app.android.deal.dealclub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter extends ArrayAdapter<DataModel>{

    private ArrayList<DataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView shopName;
        TextView shopAddress;
        TextView shopOffers;
        TextView shopTiming;
        TextView shopPhone;

    }

    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext=context;

    }


    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.shopName = (TextView) convertView.findViewById(R.id.txt_shop_name);
            viewHolder.shopAddress = (TextView) convertView.findViewById(R.id.txt_shop_name);
            viewHolder.shopOffers = (TextView) convertView.findViewById(R.id.txt_shop_name);
            viewHolder.shopTiming = (TextView) convertView.findViewById(R.id.txt_shop_name);
            viewHolder.shopPhone = (TextView) convertView.findViewById(R.id.txt_shop_name);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;
        viewHolder.shopName.setText(dataModel.get_shopName());
        viewHolder.shopAddress.setText(dataModel.get_shopAddress());
        viewHolder.shopTiming.setText(dataModel.get_shopTiming());
        viewHolder.shopOffers.setText(dataModel.get_shopOffer());
        viewHolder.shopPhone.setText(dataModel.get_shopPhone());
        // Return the completed view to render on screen
        return convertView;
    }
}
