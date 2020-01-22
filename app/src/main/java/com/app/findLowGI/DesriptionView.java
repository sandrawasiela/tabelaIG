package com.app.findLowGI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DesriptionView extends AppCompatActivity {

    HashMap results;
    Button addFavouritesButton;
    SQLHepler helper;
    boolean isInDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desription_view);

        Intent startIntent = getIntent();
        addFavouritesButton = (Button) findViewById(R.id.addButton);
        helper =new SQLHepler(this);
        results = (HashMap)startIntent.getSerializableExtra("map");
        updateButton();

       // Log.d("glikemia","widok opisu:"+results.get("name").toString());
        //Log.d("glikemia","widok opisu:"+results.get("glycemicindex").toString());
        //Log.d("glikemia","widok opisu:"+results.get("fat").toString());

        TextView nameId = findViewById(R.id.nameId);
        nameId.setText(results.get("name").toString());

        TextView glycemicindexId = findViewById(R.id.glycemicindexId);
        glycemicindexId.setText(results.get("glycemicindex").toString());

        TextView fatId = findViewById(R.id.fatId);
        fatId.setText(results.get("fat").toString()+" g");

        TextView sugarsId = findViewById(R.id.sugarsId);
        sugarsId.setText(results.get("sugars").toString()+" g");

        TextView carbohydrateId = findViewById(R.id.carbohydrateId);
        carbohydrateId.setText(results.get("carbohydrate").toString()+" g");

        TextView proteinId = findViewById(R.id.proteinId);
        proteinId.setText(results.get("protein").toString()+" g");

        TextView fibreId = findViewById(R.id.fibreId);
        fibreId.setText(results.get("fibre").toString()+" g");

        TextView saltId= findViewById(R.id.saltId);
        saltId.setText(results.get("salt").toString()+" g");

        TextView cholesterolId= findViewById(R.id.cholesterolId);
        cholesterolId.setText(results.get("cholesterol").toString()+" mg");

        TextView glutenfreeId = findViewById(R.id.glutenfreeId);

        if (results.get("glutenfree").toString() == "false"){
            glutenfreeId.setText("no");
        } else{
            glutenfreeId.setText("yes");
        }


        addFavouritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isInDatabase==true){

                    helper.deleteFood(results.get("name").toString());
                    updateButton();

                }else{

                    helper.addFood(results);
                    updateButton();

                }

            }
        });

    }

    private void updateButton(){

        Log.d("glikemia",results.get("name").toString());

        isInDatabase=helper.isInDataBase(results.get("name").toString());


        if(isInDatabase==true){

            addFavouritesButton.setText("Delete from favourites");
        }else{
            addFavouritesButton.setText("Add to favourites");
        }

    }
}
