package com.app.findLowGI;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;

public class DataDownload extends AsyncTask<String,Void,Integer> {


    private int glik;

    @Override
    protected void onPreExecute()  {
        super.onPreExecute();

        Authenticator.setDefault(new Authenticator() {
            String username="123Jan";
            String password="glikemia";
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password.toCharArray());
            }
        });


    }

    @Override
    protected Integer doInBackground(String... params) {

        try {

            URL url = new URL("https://www.nutritics.com/api/v1.1/LIST/food="+params[0]+"&attr=gi");
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine, output = "";
            while ((inputLine = in.readLine()) != null) {
                output += inputLine;
            }

            // HOW TO GET THE FIRST RESULT:
            //Log.d("glikemia","output: "+output);

            JSONObject newArr = new JSONObject(output);

            //Log.d("glikemia","Array: "+newArr.toString());

            // HOW TO LOOP THROUGH RESULTS TO GET INDIVIDUAL FIELDS:
            /*for (int i = 0; i < newArr.length(); i++) {
                JSONObject dataObj = newArr.getJSONObject(i);
                System.out.println(dataObj.getString("id"));
                Log.d("glikemia",dataObj.getString("id"));
            }*/

            glik=newArr.getJSONObject("1").getJSONObject("gi").getInt("val");



        }catch (Exception e){
            Log.d("glikemia",e.toString());
        }


        return glik;
    }
}
