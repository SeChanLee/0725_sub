package com.example.secha.a0725_sub;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity {

    Button sub_map,restaurant,con_fac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        sub_map=(Button)findViewById(R.id.sub_map);
        restaurant=(Button)findViewById(R.id.restaurant);
        con_fac=(Button)findViewById(R.id.con_fac);

        sub_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        con_fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
