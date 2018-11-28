package com.app.android.deal.dealclub;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.android.deal.dealclub.Data.GetDealResponse;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<GetDealResponse> item;
    Context context ;

    public RecyclerViewAdapter(Context context, List<GetDealResponse> item ) {
        Log.d("123", "RecyclerViewAdapter");
        this.item = item;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("123", "onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("123", "onBindViewHolder");
        holder.txt_shop_name.setText(item.get(position).getPercentage());
        holder.txt_shop_address.setText(item.get(position).getProductname());
        holder.txt_shop_offers.setText(item.get(position).getId());
        holder.txt_shop_phone.setText(item.get(position).getValidfrom());
        holder.txt_shop_timing.setText(item.get(position).getValidtill());
    }

    @Override
    public int getItemCount() {
        Log.d("123", "getItemCount");
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_shop_name, txt_shop_address,txt_shop_offers,txt_shop_phone,txt_shop_timing;

        public ViewHolder(View itemView) {
            super(itemView);
            Log.d("123", "ViewHolder");

            txt_shop_name = (TextView) itemView.findViewById(R.id.txt_shop_name);
            txt_shop_address = (TextView) itemView.findViewById(R.id.txt_shop_address);
            txt_shop_offers = (TextView) itemView.findViewById(R.id.txt_shop_offers);
            txt_shop_phone = (TextView) itemView.findViewById(R.id.txt_shop_phone);
            txt_shop_timing = (TextView) itemView.findViewById(R.id.txt_shop_timing);
        }
    }
}