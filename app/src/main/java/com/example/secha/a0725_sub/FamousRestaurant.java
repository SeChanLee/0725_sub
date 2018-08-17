package com.example.secha.a0725_sub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FamousRestaurant extends MenuActivity {

    MyDBHelper mDBHelper;
    EditText editRail,editRes,editStation,textrailResult,textresResult,textnameResult;
    Button btnInsert,btnAll,btnName;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resdate);
        mDBHelper=new MyDBHelper(this);

        editRail=(EditText)findViewById(R.id.editRail);
        editRes=(EditText)findViewById(R.id.editRes);
        editStation=(EditText)findViewById(R.id.editStation);
        textrailResult=(EditText) findViewById(R.id.textrailResult);
        textresResult=(EditText) findViewById(R.id.textresResult);
        textnameResult=(EditText) findViewById(R.id.textnameResult);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB=mDBHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO restaurant VALUES('"+editRail.getText().toString()+"',"
                        +editRes.getText().toString()+"',"+editStation.getText().toString()+");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"입력됨",Toast.LENGTH_SHORT).show();
            }
        });

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB=mDBHelper.getReadableDatabase();
                Cursor cursor;
                cursor=sqlDB.rawQuery("SELECT*FROM restaurant;",null);

                String strrails="호 선"+"\r\n"+"_______"+"\r\n";
                String strres="식 당"+"\r\n"+"_______"+"\r\n";
                String strnames="역 이름"+"\r\n"+"_______"+"\r\n";

                while(cursor.moveToNext()) {
                    strrails += cursor.getString(0)+"\r\n";
                    strres += cursor.getString(1)+"\r\n";
                    strnames += cursor.getString(2)+"\r\n";
                }
                textrailResult.setText(strrails);
                textresResult.setText(strres);
                textnameResult.setText(strnames);

                cursor.close();
                sqlDB.close();

            }
        });

    }

    public class MyDBHelper extends SQLiteOpenHelper{
        public MyDBHelper(Context context){
            super(context,"mytest.db",null,1);
        }
        public void onCreate(SQLiteDatabase db){
            db.execSQL("CREATE TABLE restaurant(rail CHAR(10) PRIMARY KEY,famous CHAR(10),station CHAR(10));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS restaurant");
            onCreate(db);

        }

    }

}

