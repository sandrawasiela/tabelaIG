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

       // Log.d("glikemia","widok opisu:"+results.get("name").toString());
        //Log.d("glikemia","widok opisu:"+results.get("glycemicindex").toString());
        //Log.d("glikemia","widok opisu:"+results.get("fat").toString());

        TextView nameId = findViewById(R.id.nameId);
        nameId.setText(results.get("name").toString());

        TextView glycemicindexId = findViewById(R.id.glycemicindexId);
        glycemicindexId.setText(results.get("glycemicindex").toString());

        TextView fatId = findViewById(R.id.fatId);
        fatId.setText(results.get("fat").toString());

        TextView sugarsId = findViewById(R.id.sugarsId);
        sugarsId.setText(results.get("sugars").toString());

        TextView carbohydrateId = findViewById(R.id.carbohydrateId);
        carbohydrateId.setText(results.get("carbohydrate").toString());

        TextView proteinId = findViewById(R.id.proteinId);
        proteinId.setText(results.get("protein").toString());

        TextView fibreId = findViewById(R.id.fibreId);
        fibreId.setText(results.get("fibre").toString());

        TextView saltId= findViewById(R.id.saltId);
        saltId.setText(results.get("salt").toString());

        TextView cholesterolId= findViewById(R.id.cholesterolId);
        cholesterolId.setText(results.get("cholesterol").toString());

        TextView glutenfreeId = findViewById(R.id.glutenfreeId);
        glutenfreeId.setText(results.get("glutenfree").toString());
    }
}
