package com.example.newprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ContentResolver resolver;
    private Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ContentResolver contentResolver=this.getContentResolver();
        uri=Uri.parse("content://provider/person");

    }
    public void onClick(View view){
        resolver = getContentResolver();
        switch (view.getId()) {
            case R.id.add:
                ContentValues content = new ContentValues();
                content.put("age",8);
                content.put("sex","M");
                resolver.insert(uri, content);
                break;
            case R.id.delete:
                break;
            case R.id.updata:
                break;
            case R.id.query:
                break;

        }
    }
}
