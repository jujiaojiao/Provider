package com.example.administrator.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ContentResolver resolver;
    private Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ContentResolver contentResolver=this.getContentResolver();
//       uri=Uri.parse("content://provider/person");

    }
//    public void onClick(View view){
//        resolver = getContentResolver();
//        switch (view.getId()) {
//            case R.id.add:
//                ContentValues content = new ContentValues();
//                content.put("age",8);
//                content.put("sex","M");
//                resolver.insert(uri, content);
//
//                break;
//            case R.id.delete:
//                resolver.delete(uri,"sex=?",new String[]{"M"});
//                break;
//            case R.id.updata:
//                ContentValues content1 = new ContentValues();
//                content1.put("age",111);
//                content1.put("sex","Man");
//                resolver.update(uri,content1,"sex=?",new String[]{"M"});
//                break;
//            case R.id.query:
//                resolver.query(uri,null,null,null,null);
//                break;
//            case R.id.call:
//                String method = "mymethod";
//                Bundle bundle = resolver.call(uri, method, null, null);
////                System.out.println("调用结果：" + bundle.getBoolean(method));
//                String  name = (String) bundle.get("name");
//                Log.e("===============", "onClick: "+name );
//
//                break;
//
//        }
//    }
}
