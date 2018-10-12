package com.example.dell.udemyapp78maclub.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "martialArtsDatabase";
    private static final int DATABASE_VERSION   =  1;
    private static final String MARSHAL_ARTS_TABLE =   "MartialArtsTable";
    private static final String ID_KEY = "id";
    private static final String NAME_KEY = "name";
    private static final String PRICE_KEY = "price";
    private static final String COLOR_KEY = "color";

    public DatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
          String createDatabaseSQL = "create table "+
                  MARSHAL_ARTS_TABLE+"("+ID_KEY+" integer primary key autoincrement"+
                  ", "+NAME_KEY+" text"+", "+PRICE_KEY+" real"+" ,"+
                  COLOR_KEY+" text"+" )";
          db.execSQL(createDatabaseSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("drop table if exists "+MARSHAL_ARTS_TABLE);
          onCreate(db);
    }
    //create a method add martial art
    public void  addMartialArt(MarshalArt marshalArtObject){
        SQLiteDatabase database = getWritableDatabase();
        String addMartailArtSQLCommand = "insert into "+MARSHAL_ARTS_TABLE+
                " values(null,'"+marshalArtObject.getMartialArtName()
                +"', '"+marshalArtObject.getMartialArtPrice()+
                "', "+marshalArtObject.getMartialArtColor()+
                "')";
        database.execSQL(addMartailArtSQLCommand);
        database.close();

    }
    //delete martial art object
    public void deleteMarshalArtObjectFromDatabaseByID(int id){
        //reference to sqlite writable database

        SQLiteDatabase database = getWritableDatabase();
        //delete
        String deleteMarshalArtSQLCommand = "delete from "+MARSHAL_ARTS_TABLE+
                " where "+ID_KEY+" = "+ id;
        database.execSQL(deleteMarshalArtSQLCommand);
        database.close();
    }
    //method to modify
    public void modifyMartialArtObject(int martialArtID,String martialArtName,double martialArtPrice,String martialArtColor){
           SQLiteDatabase database = getWritableDatabase();
            String modifyMartialArtSQLCommand = "update" + MARSHAL_ARTS_TABLE+
                    " set"+NAME_KEY+" = '" + martialArtName +
                    "', "+PRICE_KEY+" = '" +martialArtPrice +
                    "', "+COLOR_KEY+" = '" +martialArtColor +
                    "' " +"where "+ ID_KEY +" = "+ martialArtID;
             database.execSQL(modifyMartialArtSQLCommand);
             database.close();
    }
    public ArrayList<MarshalArt> returnAllMartialArtObject(){
       SQLiteDatabase database = getWritableDatabase();
       String sqlQueryCommand = "select * from "+MARSHAL_ARTS_TABLE;
        Cursor cursor = database.rawQuery(sqlQueryCommand,null);

        ArrayList<MarshalArt> marshalArts  = new ArrayList<>();
        while (cursor.moveToNext()){
            MarshalArt currentMartialArtObject = new MarshalArt(Integer.parseInt(cursor.getString(0)),cursor.getString(1),
                    cursor.getDouble(2),cursor.getString(3));
            marshalArts.add(currentMartialArtObject);
        }
        database.close();
        return marshalArts;

    }
    public MarshalArt returnMartialArtObjectByID(int id){
        SQLiteDatabase database = getWritableDatabase();
        String sqlQueryCommand = "select * from " + MARSHAL_ARTS_TABLE+" where "+ ID_KEY +" = "+ id;
        Cursor cursor = database.rawQuery(sqlQueryCommand,null);
        MarshalArt marshalArtObject = null;

        if(cursor.moveToFirst()){
            marshalArtObject = new MarshalArt(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),cursor.getDouble(2),
                    cursor.getString(3));
        }
        database.close();
        return marshalArtObject;
    }

}
