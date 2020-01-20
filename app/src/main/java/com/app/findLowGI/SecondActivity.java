package com.app.findLowGI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {

    private String food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_view);

        // button
        Button findButton = (Button) findViewById(R.id.findButton);
        findButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText productName = (EditText) findViewById(R.id.productName);
                food = productName.getText().toString();

                try {

                    // pobieranie danych z API

                    HashMap results = new DataDownload().execute(food).get();

                    Iterator hmIterator = results.entrySet().iterator();


                    while (hmIterator.hasNext()) {
                        Map.Entry mapElement = (Map.Entry) hmIterator.next();

                        Log.d("glikemia", mapElement.getKey() + ": " + mapElement.getValue());

                    }


                } catch (Exception e) {
                    Log.d("glikemia", e.toString());
                }


                Intent startIntent = new Intent(getApplicationContext(), DesriptionView.class);
                startIntent.putExtra("name",food);
                //startIntent.putExtra("Glycemicindex: ");
                startActivityForResult(startIntent,1);

            }
        });




    }
}

