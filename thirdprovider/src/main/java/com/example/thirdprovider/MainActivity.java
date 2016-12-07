package com.example.thirdprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = (TextView)findViewById(R.id.text);

        button = (Button)findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ContentResolver resolver = getContentResolver();
                Uri uri = Uri.parse("content://provider/person");

                Cursor cursor = resolver.query(uri, null, null, null, null);
                StringBuilder stringBuilder = new StringBuilder();
                while (cursor != null && cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndex("age"));
                    String money = cursor.getString(cursor.getColumnIndex("sex"));
                    stringBuilder.append(id+"+"+money+"\n");
                }
                content.setText(stringBuilder.toString());
            }
        });
    }

}
