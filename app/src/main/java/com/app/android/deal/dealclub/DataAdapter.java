package com.app.android.deal.dealclub;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class DataAdapter  extends RecyclerView.Adapter<DataAdapter.MyViewHolder>{

    public static ArrayList<DataModel> objs_arr=new ArrayList<>();
    public DataAdapter(ArrayList<DataModel> objs) {
        this.objs_arr = objs;
    }
    String imgName ;

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View buysell_view=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);

        return new MyViewHolder (buysell_view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.shopName.setText(objs_arr.get(position).get_shopName());
        holder.shopAddress.setText("  "+objs_arr.get(position).get_shopAddress());
        holder.shopOffers.setText(objs_arr.get(position).get_shopOffer());
        holder.shopTiming.setText("  "+objs_arr.get(position).get_shopTiming());
        holder.shopPhone.setText("  "+objs_arr.get(position).get_shopPhone());

        holder.shopName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(holder.shopName.getContext(),OfferDeatil.class);
                holder.shopName.getContext().startActivity(in);
            }
        });

    }
    @Override
    public int getItemCount() {
        return objs_arr.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView shopName;
        TextView shopAddress;
        TextView shopOffers;
        TextView shopTiming;
        TextView shopPhone;
        public MyViewHolder(View itemView) {
            super(itemView);
            shopName = (TextView) itemView.findViewById(R.id.txt_shop_name);
            shopAddress = (TextView) itemView.findViewById(R.id.txt_shop_address);
            shopOffers = (TextView) itemView.findViewById(R.id.txt_shop_offers);
            shopTiming = (TextView) itemView.findViewById(R.id.txt_shop_timing);
            shopPhone = (TextView) itemView.findViewById(R.id.txt_shop_phone);
        }
    }

}
