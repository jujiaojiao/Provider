package com.example.administrator.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenSql extends SQLiteOpenHelper {
    public static final String Name = "person";
    public static final int Version = 1;
    public OpenSql(Context context) {
        super(context, Name, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table person(age integer,sex varchar(20));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
