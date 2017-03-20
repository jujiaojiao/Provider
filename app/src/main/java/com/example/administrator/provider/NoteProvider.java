package com.example.administrator.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import javax.security.auth.login.LoginException;



public class NoteProvider extends ContentProvider {
    private OpenSql open;
//    public static final String TAG = "==================";

    @Override
    public boolean onCreate() {
        open = new OpenSql(this.getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        Log.e("NoteProvider", "query: "+Thread.currentThread().getName());

        SQLiteDatabase db = open.getWritableDatabase();
        Cursor person1 = db.query("person", strings, s, strings1, null, s1, null);
        return person1;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        Log.e("NoteProvider", "getType: "+Thread.currentThread().getName());
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        Log.e("NoteProvider", "insert: "+Thread.currentThread().getName());
        SQLiteDatabase db = open.getWritableDatabase();
        long person = db.insert("person", null, contentValues);
        return uri;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        Log.e("NoteProvider", "delete: "+Thread.currentThread().getName());
        SQLiteDatabase db = open.getWritableDatabase();
        int person = db.delete("person", s, strings);
        return person;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        Log.e("NoteProvider", "updata: "+Thread.currentThread().getName());
        SQLiteDatabase db = open.getWritableDatabase();
        int person = db.update("person", contentValues, s, strings);
        return person;
    }

    @Nullable
    @Override
    public Bundle call(String method, String arg, Bundle extras) {
        Log.e("NoteProvider", "call: "+Thread.currentThread().getName());
//        Log.e(TAG, "call: "+method);
//        Log.e(TAG, "call: "+arg);
//        Log.e(TAG, "call: "+extras );
        Bundle bundle = new Bundle();
        bundle.putString("name","lalala");
        return bundle;
    }
}
