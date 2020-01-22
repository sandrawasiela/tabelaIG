package com.app.findLowGI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Favourites extends AppCompatActivity {


    ListView foodListView;
    ArrayList<String> list;
    SQLHepler helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        helper=new SQLHepler(this);

        foodListView = findViewById(R.id.foodListView);

        list = helper.getAllFoodList();



        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        foodListView.setAdapter(adapter);

        foodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent startIntent = new Intent(getApplicationContext(), DesriptionView.class);

                Log.d("jedzenie",list.get(position));
                startIntent.putExtra("map",helper.getFoodStats(list.get(position)));
                startActivityForResult(startIntent,1);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        foodListView = findViewById(R.id.foodListView);
        list = helper.getAllFoodList();

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        foodListView.setAdapter(adapter);

        foodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent startIntent = new Intent(getApplicationContext(), DesriptionView.class);

                Log.d("jedzenie",list.get(position));
                startIntent.putExtra("map",helper.getFoodStats(list.get(position)));
                startActivityForResult(startIntent,1);
            }
        });
    }
}
