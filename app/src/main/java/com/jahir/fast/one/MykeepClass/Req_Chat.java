package com.jahir.fast.one.MykeepClass;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.sdk.ads.Comman;
import com.sdk.ads.LocalSave.ModelPrefrences;

import org.json.JSONException;
import org.json.JSONObject;

public class Req_Chat {

    ModelPrefrences modelPrefrences;

    private RequestQueue queue;
    private String APIkey = "null";
    private String brainID = "null";
    private String reply;
    private char[] illegalChars = {'#', '<', '>', '$', '+', '%', '!', '`', '&',
            '*', '\'', '\"', '|', '{', '}', '/', '\\', ':', '@'};

    public Req_Chat(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String reply);
    }

    private String formatMessage(String message) {

        message = message.replace(' ', '-');
        for (char illegalChar : illegalChars) {
            message = message.replace(illegalChar, '-');
        }
        return message;
    }

    public void getResponse(Activity activity, String message, final VolleyResponseListener volleyResponseListener) {

        if (Comman.mainResModel != null) {
            brainID = Comman.mainResModel.getData().getExtraFields().getChat_id();
            APIkey = Comman.mainResModel.getData().getExtraFields().getChat_key();


        }

        message = formatMessage(message);
        String url = "http://api.brainshop.ai/get?bid=" + brainID + "&key=" + APIkey + "&uid=1&msg=" + message;
        Log.e("@URL", url);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            reply = response.getString("cnt");
                            volleyResponseListener.onResponse(reply);

                        } catch (JSONException e) {
                            volleyResponseListener.onError("JSON Exception");
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        volleyResponseListener.onError("Volley Error");
                    }
                });
        queue.add(request);
    }
}
