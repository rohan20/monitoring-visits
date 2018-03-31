package com.rohantaneja.monitoringvisits.fcm;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by rohantaneja on 31/03/18.
 */

public class MyFireBaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = MyFireBaseMessagingService.class.getSimpleName();

    /**
     * Called when MESSAGE is received.
     *
     * @param remoteMessage Object representing the MESSAGE received from Firebase Cloud Messaging.
     */
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        if (remoteMessage.getData().size() > 0) {
            Map<String, String> stringMap = remoteMessage.getData();
            if (stringMap != null) {
                scheduleJob(stringMap);
            }
        }
    }

    /**
     * Schedule a job using Fire base JobDispatcher.
     */
    private void scheduleJob(Map<String, String> stringMap) {

//        //notif count
//        int notificationCount = Integer.parseInt(stringMap.get("badge"));
//        //MESSAGE
//        String message = stringMap.get("message");
//
//        NotificationCompat.Builder mBuilder =
//                new NotificationCompat.Builder(this,"M_CH_ID")
//                        .setSmallIcon(R.mipmap.ic_launcher)
//                        .setContentTitle(getString(R.string.app_name))
//                        .setContentText(message)
//                        .setDefaults(Notification.DEFAULT_ALL)
//                        .setPriority(Notification.PRIORITY_HIGH);
//
//        mBuilder.setAutoCancel(true);
//
//        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//
//        String jsonString = stringMap.get("data");
//        JSONObject jsonObject;
//        int notificationId = 0;
//        try {
//            jsonObject = new JSONObject(jsonString);
//
//            //senderIds
//            List<Integer> senderIds = new ArrayList<>();
//            JSONArray senderIdsJsonArray = jsonObject.getJSONArray("senderIds");
//            for (int i = 0; i < senderIdsJsonArray.length(); i++) {
//                senderIds.add(senderIdsJsonArray.getInt(i));
//            }
//
//            //notificationId
//            notificationId = jsonObject.getInt("notificationId");
//
//        } catch (JSONException e) {
//            LogUtils.printStackTrace(e);
//        }
//
//        //handle click
//
//        Intent resultIntent = new Intent(this, HomeMainActivity.class);
//        resultIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//        resultIntent.setAction(Intent.ACTION_MAIN);
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_ONE_SHOT);
//        mBuilder.setContentIntent(pendingIntent);
//        // notificationId allows you to update the notification later on.
//        notificationManager.notify(notificationId, mBuilder.build());
//
//        sendInAppNotification(message);

    }

    /**
     * Handle time allotted to BroadcastReceivers.
     */
    private void handleNow(String msg, int jobId, String name, int usrType, String createdAt) {

    }


}
