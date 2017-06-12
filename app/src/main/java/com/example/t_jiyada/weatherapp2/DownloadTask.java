package com.example.t_jiyada.weatherapp2;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamCorruptedException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by t-jiyada on 07-06-2017.
 */

public class DownloadTask extends AsyncTask<String,Void,String>{

    String result ="";
    URL url;

    HttpURLConnection urlConnection = null;

    @Override
    protected String doInBackground(String... urls) {

        try {
            url = new URL(urls[0]);

            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);

            int data = reader.read();

            while(data!= -1){
                char current = (char) data;

                result += current;

                data = reader.read();

            }
            return result;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        try{
            JSONObject jsonObject = new JSONObject(result);

            JSONObject weather = new JSONObject(jsonObject.getString("main"));

            Double temp = Double.parseDouble(weather.getString("temp"));

            int tempi = (int) (temp - 273.15);

            String Place = jsonObject.getString("name");

            showact.placetv.setText(String.valueOf(Place));
            showact.temptv.setText(String.valueOf(tempi));

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
    }
}
