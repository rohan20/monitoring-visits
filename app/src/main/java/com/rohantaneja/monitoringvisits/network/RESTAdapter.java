package com.rohantaneja.monitoringvisits.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rohantaneja on 30/03/18.
 */

public class RESTAdapter {

    private MinistryDataAPI ministryDataAPI;

    public RESTAdapter(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ministryDataAPI = retrofit.create(MinistryDataAPI.class);
    }

    public MinistryDataAPI getMinistryDataAPI() {
        return ministryDataAPI;
    }
}
