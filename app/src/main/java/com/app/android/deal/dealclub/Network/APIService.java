package com.app.android.deal.dealclub.Network;


import com.app.android.deal.dealclub.Data.GetDealResponse;
import com.app.android.deal.dealclub.Data.LoginResponse;
import com.app.android.deal.dealclub.Data.RegistrationResponse;
import com.app.android.deal.dealclub.Data.UserData;
import com.app.android.deal.dealclub.Data.LoginData;
import com.app.android.deal.dealclub.Movie;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {


    @POST("/DealClub/Authentication")
    Call<LoginResponse> postLogin(

            @Body LoginData loginData


            );




    @POST("/DealClub/CreateCustomer")
    Call<RegistrationResponse> createUser(@Body UserData userData);



//@GET("/DealClub/GetDeal")
//Call<List<GetDealResponse>> getDeal();

    @GET("/DealClub/GetDeal")
    Call<List<Movie>> getMovies();



    @GET("/DealClubAuthentication")
    Call<ServerResponse> get(

            @Query("email") String username, @Query("password") String password);


    @POST("/DealClub/Authentication")
    Call<ServerResponse> postSingle(

            @Body RequestBody password

    );
}
