package com.rohantaneja.monitoringvisits.network.cloudmessaging;

import android.content.SharedPreferences;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.gson.Gson;
import com.rohantaneja.monitoringvisits.model.User;
import com.rohantaneja.monitoringvisits.network.RESTAdapter;

/**
 * Created by ralph on 31/03/18.
 */

public class TokenService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        // Instance ID token to your app server.
        SharedPreferences sharedPreferences = getSharedPreferences("SIH",MODE_PRIVATE);
        String userString = sharedPreferences.getString("user",null);
        if(userString != null){
            Gson gson = new Gson();
            User user = gson.fromJson(userString,User.class);
            RESTAdapter.getInstance().getMinistryDataAPI().registerDevice(user.getId(),refreshedToken);

        }

    }
}
