package com.yanickouellet.carpooling.background;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.yanickouellet.carpooling.AppConstants;
import com.yanickouellet.carpooling.storage.Serializer;

import java.io.IOException;
import java.util.ArrayList;

import none.carpooling.Carpooling;
import none.carpooling.model.RunOffer;
import none.carpooling.model.RunOfferCollection;
import none.carpooling.model.RunRequest;
import none.carpooling.model.RunRequestCollection;

public class PullDataService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    private static final String ACTION_DOWNLOAD = "com.yanickouellet.carpooling.background.action.DOWNLOAD";

    public static void startActionDownload(Context context) {
        Intent intent = new Intent(context, PullDataService.class);
        intent.setAction(ACTION_DOWNLOAD);
        context.startService(intent);
    }

    public PullDataService() {
        super("PullDataService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_DOWNLOAD.equals(action)) {
                handleActionDownload();
            }
        }
    }

    private void handleActionDownload() {
        String emailAccount = getSharedPreferences("Carpooling", 0)
                .getString(AppConstants.PREF_ACCOUNT_NAME_KEY, null);

        Log.i("Service", "test");
        if(emailAccount != null) {
            GoogleAccountCredential credential = GoogleAccountCredential.usingAudience(getApplicationContext(), AppConstants.AUDIENCE);
            credential.setSelectedAccountName(emailAccount);

            try {
                String accessToken = credential.getToken();
                AppConstants.setCredential(credential);
                Carpooling service =  AppConstants.getApiServiceHandle();
                Serializer serializer = new Serializer(getApplicationContext());

                RunRequestCollection requestsCollection = service.runrequest().list().execute();

                if(requestsCollection != null && requestsCollection.getItems() != null) {
                    ArrayList<RunRequest> requests = new ArrayList<>();
                    requests.addAll(requestsCollection.getItems());
                    serializer.writeObject(requests, "requests.bin");
                }

                RunOfferCollection offersCollection = service.runoffer().list().execute();

                if(offersCollection != null && offersCollection.getItems() != null) {
                    ArrayList<RunOffer> offers = new ArrayList<>();
                    offers.addAll(offersCollection.getItems());
                    serializer.writeObject(offers, "offers.bin");
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (GoogleAuthException e) {
                e.printStackTrace();
            }
        }
    }
}
