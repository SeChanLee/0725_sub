package com.example.secha.a0725_sub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class SubwayLineActivity extends MenuActivity {

    FrameLayout container;
    Button r1,r2,r3,r4,r5,r6,r7,r8,r9,reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subwayline);

        container=(FrameLayout)findViewById(R.id.container);//프레임 레이아웃
        //각 호선들
        r1=(Button)findViewById(R.id.r1);
        r2=(Button)findViewById(R.id.r2);
        r3=(Button)findViewById(R.id.r3);
        r4=(Button)findViewById(R.id.r4);
        r5=(Button)findViewById(R.id.r5);
        r6=(Button)findViewById(R.id.r6);
        r7=(Button)findViewById(R.id.r7);
        r8=(Button)findViewById(R.id.r8);
        r9=(Button)findViewById(R.id.r9);

        reset=(Button)findViewById(R.id.reset);//초기화 버튼

        //1호선 클릭이벤트, 레이아웃 붙이기
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.rail1, container, true);
            }
        });


    }
}
