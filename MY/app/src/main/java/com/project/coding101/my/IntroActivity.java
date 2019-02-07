package com.project.coding101.my;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        TextView mj_num = (TextView)findViewById(R.id.mj_num);
        mj_num.setAutoLinkMask(Linkify.PHONE_NUMBERS);

//        Button soft_btn = (Button) findViewById(R.id.major_soft);
//        soft_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Application_Soft.class);
//                startActivity(intent);
//            }
//        });

//        Button data_btn = (Button) findViewById(R.id.major_data);
//        data_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Data_Tech.class);
//                startActivity(intent);
//            }
//        });

//        Button acad_btn = (Button) findViewById(R.id.intro_academy);
//        acad_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Academy.class);
//                startActivity(intent);
//            }
//        });
    }
}