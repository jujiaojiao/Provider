package com.example.newprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/12/7.
 */

public class TestProvider extends ContentProvider {
    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        Log.e("TestProvider", "query: ");
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        Log.e("TestProvider", "getType: ");
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        Log.e("TestProvider", "insert: ");
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        Log.e("TestProvider", "delete: ");
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        Log.e("TestProvider", "updata: ");
        return 0;
    }
}
