package com.rohantaneja.monitoringvisits.network;

import com.rohantaneja.monitoringvisits.model.User;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rohantaneja on 30/03/18.
 */

public interface MinistryDataAPI {

    @POST("/users/signup")
    Call<User> signUp(@Query("name") String name, @Query("email") String email,@Query("password") String password);

    @POST("/users/login")
    Call<User> login(@Query("email") String email,@Query("password") String password);

}
