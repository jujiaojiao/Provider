package com.example.thirdprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView content;
    private ContentResolver resolver;
    private Uri uri;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uri=Uri.parse("content://provider/person");
        text = ((TextView) findViewById(R.id.text));

//        content = (TextView)findViewById(R.id.text);
//
//        button = (Button)findViewById(R.id.add);
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                ContentResolver resolver = getContentResolver();
//                Uri uri = Uri.parse("content://provider/person");
//
//                Cursor cursor = resolver.query(uri, null, null, null, null);
//                StringBuilder stringBuilder = new StringBuilder();
//                while (cursor != null && cursor.moveToNext()) {
//                    int id = cursor.getInt(cursor.getColumnIndex("age"));
//                    String money = cursor.getString(cursor.getColumnIndex("sex"));
//                    stringBuilder.append(id+"+"+money+"\n");
//                }
//                content.setText(stringBuilder.toString());
//            }
//        });
    }
    public void onClick(View view) {
        Log.e("**************", "onClick: "+Thread.currentThread().getName() );
        resolver = getContentResolver();
        switch (view.getId()) {
            case R.id.add:
                ContentValues content = new ContentValues();
                content.put("age", 8);
                content.put("sex", "M");
                resolver.insert(uri, content);

                break;
            case R.id.delete:
                resolver.delete(uri, "sex=?", new String[]{"Man"});
                break;
            case R.id.updata:
                ContentValues content1 = new ContentValues();
                content1.put("age", 111);
                content1.put("sex", "Man");
                resolver.update(uri, content1, "sex=?", new String[]{"M"});
                break;
            case R.id.query:
                Cursor cursor = resolver.query(uri, null, null, null, null);
                StringBuilder stringBuilder = new StringBuilder();
                while (cursor != null && cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndex("age"));
                    String money = cursor.getString(cursor.getColumnIndex("sex"));
                    stringBuilder.append(id+"+"+money+"  ");
                }
//                content.setText(stringBuilder.toString());
                text.setText(stringBuilder.toString());
                break;
            case R.id.call:
                String method = "mymethod";
                Bundle bundle = resolver.call(uri, method, null, null);
//                System.out.println("调用结果：" + bundle.getBoolean(method));
                String name = (String) bundle.get("name");
                Log.e("===============", "onClick: " + name);

                break;

        }
    }
}
