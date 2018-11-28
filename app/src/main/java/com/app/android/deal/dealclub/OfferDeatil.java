package com.app.android.deal.dealclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.app.android.deal.dealclub.Data.GetDealResponse;
import com.app.android.deal.dealclub.Network.APIService;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OfferDeatil extends AppCompatActivity {
List<GetDealResponse> deallist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_deatil);

        //Deal_post();










    }


    public void onBackClick(View v)
    {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Intent in = new Intent(OfferDeatil.this,HomePage.class);
        startActivity(in);
        finish();
    }

    public void onClickGetDeal(View v)
    {
        Intent in = new Intent(OfferDeatil.this,QrCodeActivity.class);
        startActivity(in);
        finish();
    }
}
