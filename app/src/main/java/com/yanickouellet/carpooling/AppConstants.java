package com.yanickouellet.carpooling;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;

import none.carpooling.Carpooling;

public class AppConstants {

    public static final String WEB_CLIENT_ID = "167365633595-uqt0ar2ft41ppjto2ce0kpvfdnnqglp8.apps.googleusercontent.com";
    public static final String AUDIENCE = "server:client_id:" + WEB_CLIENT_ID;
    public static final JsonFactory JSON_FACTORY = new AndroidJsonFactory();
    private static GoogleAccountCredential googleCredential = null;

    public static final HttpTransport HTTP_TRANSPORT = AndroidHttp.newCompatibleTransport();

    public static int countGoogleAccounts(Context context) {
        AccountManager am = AccountManager.get(context);
        Account[] accounts = am.getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
        if (accounts == null || accounts.length < 1) {
            return 0;
        } else {
            return accounts.length;
        }
    }

    public static boolean checkGooglePlayServicesAvailable(Activity activity) {
        final int connectionStatusCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (GooglePlayServicesUtil.isUserRecoverableError(connectionStatusCode)) {
            Toast.makeText(activity, activity.getString(R.string.google_service_unavailable), Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public static Carpooling getApiServiceHandle() {
        // Use a builder to help formulate the API request.
        Carpooling.Builder carpooling = new Carpooling.Builder(AppConstants.HTTP_TRANSPORT,
                AppConstants.JSON_FACTORY, googleCredential);

        return carpooling.build();
    }

    public static void setCredential(GoogleAccountCredential credential) {
        googleCredential = credential;
    }

}