package com.app.findLowGI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;


public class SecondActivity extends AppCompatActivity {

    private String food;
    private HashMap results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_view);

        // button
        Button findButton = (Button) findViewById(R.id.findButton);
        Button favouritesButton = (Button) findViewById(R.id.favouritesButton);
        findButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText productName = (EditText) findViewById(R.id.productName);
                food = productName.getText().toString();

                try {

                    // pobieranie danych z API

                    results = new DataDownload().execute(food).get();


                } catch (Exception e) {
                    Log.d("glikemia", e.toString());
                }

                if (results != null) {
                    Intent startIntent = new Intent(getApplicationContext(), DesriptionView.class);
                    startIntent.putExtra("map", results);
                    startActivityForResult(startIntent, 1);
                } else {
                    Toast.makeText(SecondActivity.this, "Nothing found. Please try again", Toast.LENGTH_SHORT).show();


                }
            }

        });

        favouritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(getApplicationContext(), Favourites.class);
                startActivity(start);
            }
        });


    }
}

