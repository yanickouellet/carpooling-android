package com.yanickouellet.carpooling;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;

import none.carpooling.Carpooling;

public class AppConstants {

    public static final JsonFactory JSON_FACTORY = new AndroidJsonFactory();

    public static final HttpTransport HTTP_TRANSPORT = AndroidHttp.newCompatibleTransport();

    public static Carpooling getApiServiceHandle() {
        // Use a builder to help formulate the API request.
        Carpooling.Builder carpooling = new Carpooling.Builder(AppConstants.HTTP_TRANSPORT,
                AppConstants.JSON_FACTORY, null);

        return carpooling.build();
    }

}