package com.app.findLowGI;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class SQLHepler extends SQLiteOpenHelper {

    private static final String CREATE_TABLE="CREATE TABLE FoodData("+
            "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "Name TEXT,"+
            "GlycemicIndex REAL,"+
            "EnergyKcal REAL,"+
            "Protein REAL,"+
            "Fat REAL,"+
            "Sugars REAL,"+
            "Fibre REAL,"+
            "Carbohydrate REAL,"+
            "Salt REAL,"+
            "Cholesterol REAL,"+
            "glutenfree TEXT);";


    public SQLHepler(Context context){
        super(context, "foodDataBase.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addFood(String name, int gi, double energyKcal, double protein, double fat, double sugars, double fibre, double carbohydrate,double salt,double cholesterol,String glutenFree ){


        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("Name", name);
        values.put("GlycemicIndex", gi);
        values.put("EnergyKcal", energyKcal);
        values.put("Protein", protein);
        values.put("Fat", fat);
        values.put("Sugars", sugars);
        values.put("Fibre", fibre);
        values.put("Carbohydrate", carbohydrate);
        values.put("Salt", salt);
        values.put("Cholesterol", cholesterol);
        values.put("glutenfree", glutenFree);

        db.insert("FoodData", null, values);

    }

    public Cursor getFoodStats (String name) {

        String[] columns = new String[]{"Name", "GlycemicIndex", "EnergyKcal", "Protein", "Fat", "Sugars", "Fibre", "Carbohydrate", "Salt", "Cholesterol", "glutenfree"};
        SQLiteDatabase db = this.getReadableDatabase();



        Cursor res = db.query("FoodData", columns, "name=?", new String[]{name}, null, null, null);
        Log.d("Cursor Object", DatabaseUtils.dumpCursorToString(res));
        return res;


        //Cursor res =  db.rawQuery( "select * from FoodData where Name="+name+"",null );



    }

    public void deleteFood (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("FoodData", "name = ? ", new String[] { name });
    }

    public ArrayList<String> getAllFoodList(){

        ArrayList<String> food_list = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from FoodData", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            food_list.add(res.getString(res.getColumnIndex("Name")));
            res.moveToNext();
        }
        return food_list;
    }

}
