package com.app.android.deal.dealclub.Network;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.app.android.deal.dealclub.HomePage;
import com.app.android.deal.dealclub.Data.LoginResponse;
import com.app.android.deal.dealclub.Data.RegistrationResponse;
import com.app.android.deal.dealclub.Data.UserData;
import com.app.android.deal.dealclub.Data.LoginData;
import com.app.android.deal.dealclub.LoginPage;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCommunicator {
    private static final String TAG = "communicator";
    private static final String SERVER_URL = "http://192.168.1.112:8080";
    private Context context;

    public ApiCommunicator(Context context) {
        this.context = context;

    }

    public void Login_Post(String username, String password) {
        //Here a logging interceptor is created
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //The logging interceptor will be added to the http client
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        //The Retrofit builder will have the client attached, in order to get connection logs
        Retrofit retrofit = new Retrofit.Builder().client(httpClient.build()).addConverterFactory(GsonConverterFactory.create()).baseUrl(SERVER_URL).build();
        APIService service = retrofit.create(APIService.class);




        LoginData loginData  =new LoginData(username,password);

        Call<LoginResponse> call = service.postLogin(loginData);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse mLoginObject = response.body();
                String message = mLoginObject.getMessage();
                String status = mLoginObject.getStatus();

                    Intent intent = new Intent(context, HomePage.class);
                    context.startActivity(intent);


                Toast.makeText(context, "Returned " + message+status, Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });



    }


    public void Register_Post(String name, final String contact, String email, String dob, String gender, String password) {
        //Here a logging interceptor is created
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //The logging interceptor will be added to the http client
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        //The Retrofit builder will have the client attached, in order to get connection logs
        Retrofit retrofit = new Retrofit.Builder().client(httpClient.build()).addConverterFactory(GsonConverterFactory.create()).baseUrl(SERVER_URL).build();

        APIService service = retrofit.create(APIService.class);


        UserData userData = new UserData(name, gender, contact, dob, email, password);



        Call<RegistrationResponse> call = service.createUser(userData);


        call.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {


                RegistrationResponse registrationResponse = response.body();
            if(response.isSuccessful())
            {


                Intent intent = new Intent(context, LoginPage.class);
                context.startActivity(intent);

                Toast.makeText(context, registrationResponse.getMessage(), Toast.LENGTH_SHORT).show();

            }




            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {

            }
        });




    }





    }

