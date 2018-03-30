package com.rohantaneja.monitoringvisits.network;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by rohantaneja on 30/03/18.
 */

public class NetworkUtil {

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

}
