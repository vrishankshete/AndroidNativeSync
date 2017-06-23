package com.example.shetev.myfirstapp;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import cz.msebera.android.httpclient.Header;

/**
 * Created by shetev on 6/21/2017.
 */

public class SyncAdapter extends AbstractThreadedSyncAdapter {

    private static final String REST_HELPER_API = "http://10.38.73.198:8999/api/patient/1000033";


    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
    }

    @Override
    public void onPerformSync(Account account, Bundle bundle, String s, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(REST_HELPER_API, new JsonHttpResponseHandler(){
            @Override
            public void onStart() {
                Log.i("Vrishank","Start");
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.i("Vrishank","Success "+response.toString());
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.i("Vrishank","Failed");
            }
            @Override
            public void onRetry(int retryNo) {
                Log.i("Vrishank","Retry");
            }
        });
    }
}
