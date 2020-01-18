package com.app.findLowGI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

        private String food = "banana";
        private static int SPLASH_TIME_OUT = 4000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.second_view);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(homeIntent);
                    finish();

                }
            }, SPLASH_TIME_OUT);

            //button
            Button findButton = (Button) findViewById(R.id.findButton);
            findButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText productName = (EditText) findViewById(R.id.productName);
                }
            });




            // pobieranie danych z API

            try {

                HashMap results =new DataDownload().execute(food).get();

                Iterator hmIterator = results.entrySet().iterator();


                while (hmIterator.hasNext()) {
                    Map.Entry mapElement = (Map.Entry) hmIterator.next();

                    Log.d("glikemia",mapElement.getKey()+": "+mapElement.getValue());

                }


            }catch (Exception e)
            {
                Log.d("glikemia",e.toString());
            }


        }


}
