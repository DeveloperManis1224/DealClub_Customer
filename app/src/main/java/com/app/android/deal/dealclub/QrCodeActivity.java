package com.app.android.deal.dealclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class QrCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
    }

    public void onClickBack(View v)
    {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Intent in = new Intent(QrCodeActivity.this,OfferDeatil.class);
        startActivity(in);
        finish();
    }
}
