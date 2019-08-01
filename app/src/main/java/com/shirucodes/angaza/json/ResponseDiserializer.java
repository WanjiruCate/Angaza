package com.shirucodes.angaza.json;

import android.util.Log;

import com.shirucodes.angaza.models.Paragraph;
import com.shirucodes.angaza.models.Verification;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class ResponseDiserializer {

    private static final String TAG = ResponseDiserializer.class.getSimpleName();
    public static ArrayList<Paragraph> paragraphArrayList = new ArrayList<Paragraph>();

    public static ArrayList<Paragraph> deserializeVerificationResult(StringBuffer rawApiResultStringBuffer) {


        try {

            paragraphArrayList.clear();
            JSONObject jsonpObject = new JSONObject(rawApiResultStringBuffer.toString());
            JSONArray jsonArray = jsonpObject.getJSONArray("results");

            for (int index = 0; index < jsonArray.length(); index++) {

                try {
                    JSONObject jsonObject = jsonArray.getJSONObject(index);
                    Paragraph paragraph = new Paragraph();


                    if (jsonObject.getString("para") != null) {
                        paragraph.setParagraphText(jsonObject.getString("para"));

                    } else {
                        paragraph.setParagraphText("No respective paragraph");
                    }


                    if (jsonObject.getInt("score") != 0) {
                        paragraph.setParagraphScore(Integer.parseInt("score"));
                    } else {
                        paragraph.setParagraphScore(0);
                    }

                    paragraphArrayList.add(paragraph);

                } catch (Exception e) {
                    Log.e(TAG, "deserializeVerificationResult: " + e);
                }

            }

            return paragraphArrayList;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "deserializeCarepointData: " + e);

            return new ArrayList<>();
        }

    }
}
