package com.app.findLowGI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DesriptionView extends AppCompatActivity {

    HashMap results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desription_view);

        Intent startIntent = getIntent();

         results = (HashMap)startIntent.getSerializableExtra("map");



        Log.d("glikemia","widok opisu:"+results.get("name").toString());
        Log.d("glikemia","widok opisu:"+results.get("glycemicindex").toString());
        Log.d("glikemia","widok opisu:"+results.get("fat").toString());

        //String food = startIntent.getStringExtra("name");


        TextView nameId = findViewById(R.id.nameId);
        //nameId.setText(food);
    }
}
