package com.example.administrator.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by Administrator on 2016/12/7.
 */

public class NoteProvider extends ContentProvider {
    private OpenSql open;


    @Override
    public boolean onCreate() {
        open = new OpenSql(this.getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        Log.e("NoteProvider", "query: ");
        SQLiteDatabase db = open.getWritableDatabase();
        Cursor person1 = db.query("person", strings, s, strings1, null, s1, null);
        return person1;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        Log.e("NoteProvider", "getType: ");
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        Log.e("NoteProvider", "insert: ");
        Toast.makeText(getContext(), "insert", Toast.LENGTH_SHORT).show();
        SQLiteDatabase db = open.getWritableDatabase();
        long person = db.insert("person", null, contentValues);
        return uri;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        Log.e("NoteProvider", "delete: ");
        SQLiteDatabase db = open.getWritableDatabase();
        int person = db.delete("person", s, strings);
        return person;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        Log.e("NoteProvider", "updata: ");
        SQLiteDatabase db = open.getWritableDatabase();
        int person = db.update("person", contentValues, s, strings);
        return person;
    }
}
