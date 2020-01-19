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
import java.util.HashMap;

public class DataDownload extends AsyncTask<String,Void,HashMap> {



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
    protected HashMap doInBackground(String... Strings) {

        HashMap nutritions = new HashMap();

        try {

            URL url = new URL("https://www.nutritics.com/api/v1.1/LIST/food="+Strings[0]+"&attr=name,gi,energyKcal,protein,fat,sugars,fibre,carbohydrate,salt,cholesterol,glutenfree");
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine, output = "";
            while ((inputLine = in.readLine()) != null) {
                output += inputLine;
            }

            // HOW TO GET THE FIRST RESULT:
            //Log.d("glikemia","output: "+output);

            JSONObject newArr = new JSONObject(output);



            nutritions.put("name",newArr.getJSONObject("1").getString("name"));
            nutritions.put("glycemicindex",newArr.getJSONObject("1").getJSONObject("gi").getInt("val"));
            nutritions.put("fat",newArr.getJSONObject("1").getJSONObject("fat").getDouble("val"));
            nutritions.put("sugars",newArr.getJSONObject("1").getJSONObject("sugars").getDouble("val"));
            nutritions.put("carbohydrate",newArr.getJSONObject("1").getJSONObject("carbohydrate").getDouble("val"));
            nutritions.put("protein",newArr.getJSONObject("1").getJSONObject("protein").getDouble("val"));
            nutritions.put("fibre",newArr.getJSONObject("1").getJSONObject("fibre").getDouble("val"));
            nutritions.put("salt",newArr.getJSONObject("1").getJSONObject("salt").getDouble("val"));
            nutritions.put("cholesterol",newArr.getJSONObject("1").getJSONObject("cholesterol").getDouble("val"));
            nutritions.put("glutenfree",newArr.getJSONObject("1").getBoolean("glutenfree"));




        }catch (Exception e){
            Log.d("glikemia",e.toString());
        }


        return nutritions;
    }
}
