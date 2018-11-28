package com.app.android.deal.dealclub;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyviewHolder> {

    Context context;
    List<Movie> movieList;

    public RecyclerAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerAdapter.MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyviewHolder holder, int position) {
        holder.productname.setText(movieList.get(position).getProductname());
        holder.percentage.setText(movieList.get(position).getPercentage());
        holder.validfrom.setText(movieList.get(position).getValidfrom());
        holder.validtill.setText(movieList.get(position).getValidtill());
        holder.id.setText(movieList.get(position).getId());

        Log.v("asdasdasdsa",movieList.get(position).getProductname());


    }

    @Override
    public int getItemCount() {
        if(movieList != null){
            return movieList.size();
        }
        return 0;

    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView productname,percentage,validfrom,validtill,id;


        public MyviewHolder(View itemView) {
            super(itemView);
            productname = (TextView)itemView.findViewById(R.id.productname);
            percentage = (TextView)itemView.findViewById(R.id.percentage);
            validfrom = (TextView)itemView.findViewById(R.id.validfrom);
            validtill = (TextView)itemView.findViewById(R.id.validtill);
            id = (TextView)itemView.findViewById(R.id.id);

        }
    }
}