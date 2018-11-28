package com.app.android.deal.dealclub;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.app.android.deal.dealclub.Data.GetDealResponse;
import com.app.android.deal.dealclub.Data.RegistrationResponse;
import com.app.android.deal.dealclub.Data.UserData;
import com.app.android.deal.dealclub.Network.APIService;
import com.app.android.deal.dealclub.Network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomePage extends AppCompatActivity {
    private static final String SERVER_URL = "http://192.168.1.112:8080";
    CustomPagerAdapter mCustomPagerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<DataModel> dataModels;
    RecyclerView listView;
    private static DataAdapter adapter;
    List<Movie> movieList;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    ArrayList<DataModel> name=new ArrayList<>();


    private LinearLayoutManager layoutManager;
    List<GetDealResponse> userList =null;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        movieList = new ArrayList<>();
        recyclerView = findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //The logging interceptor will be added to the http client
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        //The Retrofit builder will have the client attached, in order to get connection logs
        Retrofit retrofit = new Retrofit.Builder().client(httpClient.build()).addConverterFactory(GsonConverterFactory.create()).baseUrl(SERVER_URL).build();

        APIService service = retrofit.create(APIService.class);






        Call<List<Movie>> call = service.getMovies();

    call.enqueue(new Callback<List<Movie>>() {
    @Override
    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {


        movieList=response.body();

        Log.v("dsasdsdsad",movieList.size()+"");
                recyclerAdapter = new RecyclerAdapter(HomePage.this,movieList);
                recyclerView.setAdapter(recyclerAdapter);


    }

    @Override
    public void onFailure(Call<List<Movie>> call, Throwable t) {

    }
});



    }





}
