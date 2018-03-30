package com.rohantaneja.monitoringvisits.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rohantaneja on 30/03/18.
 */

public class RESTAdapter {

    private static RESTAdapter instance;

    public static RESTAdapter getInstance() {
        if(instance == null){
            instance = new RESTAdapter();
        }
        return instance;
    }

    private MinistryDataAPI ministryDataAPI;

    private RESTAdapter() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.9:8080/SIHMonitoring/Rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ministryDataAPI = retrofit.create(MinistryDataAPI.class);
    }

    public MinistryDataAPI getMinistryDataAPI() {
        return ministryDataAPI;
    }
}
