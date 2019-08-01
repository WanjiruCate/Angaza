package com.shirucodes.angaza.http;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequests {

    private static final String TAG = HttpRequests.class.getSimpleName();

    public static StringBuffer getRawVerificationResult(String newsUrlToVerify) {
        try {
            /** initializing StringBuilder  */
            StringBuilder stringBuilder = new StringBuilder()
                    .append("https://stl-v2.herokuapp.com/api/v2/get?url=")
                    .append(newsUrlToVerify);

            /** searching for url */
            URL url = new URL(stringBuilder.toString());
            Log.e(TAG, "getRawVerificationResult: " + newsUrlToVerify);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();

            String outputData = "";

            while ((outputData = bufferedReader.readLine()) != null) {
                Log.e(TAG, "getRawVerificationResult: " + outputData);
                stringBuffer.append(outputData);
            }

            Log.e(TAG, "loaded with size of  => " + "Size is " + stringBuffer.length());

            return stringBuffer;

        } catch (Exception e) {
            Log.e(TAG, "onPreExecute excemption" + e);

            return null;

        }

    }
}
