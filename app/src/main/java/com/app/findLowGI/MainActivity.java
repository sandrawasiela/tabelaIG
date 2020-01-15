package com.app.findLowGI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

        private String food="banana";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            try {

                int wynik =new DataDownload().execute(food).get();

                Log.d("glikemia","osstateczny wynik:"+Integer.toString(wynik));

            }catch (Exception e)
            {
                Log.d("glikemia",e.toString());
            }


        }


}
