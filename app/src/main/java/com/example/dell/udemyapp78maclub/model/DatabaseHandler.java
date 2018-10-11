package com.example.dell.udemyapp78maclub.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    }
}
