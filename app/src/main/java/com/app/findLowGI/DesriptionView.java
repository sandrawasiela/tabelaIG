package com.app.findLowGI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DesriptionView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desription_view);

        Intent startIntent = getIntent();

        String food = startIntent.getStringExtra("name");

        TextView nameId = findViewById(R.id.nameId);
        nameId.setText(food);
    }
}
