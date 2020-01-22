package com.app.findLowGI;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.DatabaseUtils;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Iterator;
        import java.util.Map;
        import java.util.jar.Attributes;

public class SQLHepler extends SQLiteOpenHelper {

    private static final String CREATE_TABLE = "CREATE TABLE FoodData(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Name TEXT," +
            "GlycemicIndex REAL," +
            "EnergyKcal REAL," +
            "Protein REAL," +
            "Fat REAL," +
            "Sugars REAL," +
            "Fibre REAL," +
            "Carbohydrate REAL," +
            "Salt REAL," +
            "Cholesterol REAL," +
            "glutenfree TEXT);";


    public SQLHepler(Context context) {
        super(context, "foodDataBase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addFood(HashMap map) {


        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        Iterator hmIterator = map.entrySet().iterator();


        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) hmIterator.next();

            Log.d("jedzenie", mapElement.getKey() + ": " + mapElement.getValue());

        }

        values.put("Name", map.get("name").toString());
        values.put("GlycemicIndex", (Integer) map.get("glycemicindex"));
        values.put("Protein", (Double) map.get("protein"));
        values.put("Fat", (Double) map.get("fat"));
        values.put("Sugars", (Double) map.get("sugars"));
        values.put("Fibre", (Double) map.get("fibre"));
        values.put("Carbohydrate", (Double) map.get("carbohydrate"));
        values.put("Salt", (Double) map.get("salt"));
        values.put("Cholesterol", (Double) map.get("cholesterol"));
        values.put("glutenfree", map.get("glutenfree").toString());

        db.insert("FoodData", null, values);

    }

    public HashMap getFoodStats(String name) {

        String[] columns = new String[]{"Name", "GlycemicIndex", "EnergyKcal", "Protein", "Fat", "Sugars", "Fibre", "Carbohydrate", "Salt", "Cholesterol", "glutenfree"};
        SQLiteDatabase db = this.getReadableDatabase();
        HashMap map = new HashMap();


        Cursor res = db.query("FoodData", columns, "name=?", new String[]{name}, null, null, null);
        res.moveToFirst();

        map.put("name", res.getString(res.getColumnIndex("Name")));
        map.put("glycemicindex", res.getDouble(res.getColumnIndex("GlycemicIndex")));
        map.put("fat", res.getDouble(res.getColumnIndex("Fat")));
        map.put("sugars", res.getDouble(res.getColumnIndex("Sugars")));
        map.put("carbohydrate", res.getDouble(res.getColumnIndex("Carbohydrate")));
        map.put("protein", res.getDouble(res.getColumnIndex("Protein")));
        map.put("fibre", res.getDouble(res.getColumnIndex("Fibre")));
        map.put("salt", res.getDouble(res.getColumnIndex("Salt")));
        map.put("cholesterol", res.getDouble(res.getColumnIndex("Cholesterol")));
        map.put("glutenfree", res.getString(res.getColumnIndex("glutenfree")));

        return map;


    }

    public void deleteFood(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("FoodData", "name = ? ", new String[]{name});
    }

    public ArrayList<String> getAllFoodList() {

        ArrayList<String> food_list = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from FoodData", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            food_list.add(res.getString(res.getColumnIndex("Name")));
            res.moveToNext();
        }
        return food_list;
    }

    public boolean isInDataBase(String name) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        cursor = db.query("FoodData", new String[]{"name"}, "name=?", new String[]{name}, null, null, null);

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }

}
