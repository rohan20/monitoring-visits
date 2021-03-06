package com.rohantaneja.monitoringvisits.network;

import com.rohantaneja.monitoringvisits.model.User;
import com.rohantaneja.monitoringvisits.network.response.TasksResponse;
import com.rohantaneja.monitoringvisits.network.response.VisitsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rohantaneja on 30/03/18.
 */

public interface MinistryDataAPI {

    @POST("officerService/signup")
    Call<User> signUp(@Query("name") String name, @Query("email") String email,@Query("password") String password);

    @GET("officerService/login")
    Call<User> login(@Query("email") String email,@Query("password") String password);

    @GET("visitService/getAll")
    Call<VisitsResponse> getVisits(@Query("taskId") int taskId);

    @GET("taskService/getAll")
    Call<TasksResponse> getTasks(@Query("userId") int userId);

    @GET("officerService/register")
    Call<Boolean> registerDevice(@Query("userId") int userId,@Query("gcmToken")String token);

}
