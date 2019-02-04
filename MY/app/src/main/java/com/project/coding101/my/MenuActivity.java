package com.project.coding101.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;

    Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_logout = findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그아웃 기능
            }
        });

    }
//    @Override
    public void onClick(View v) {
//        int i =v.getId();
//        switch (i){
//            case R.id.btn_calculate:
//                //Intent intent = new Intent(MenuActivity.this,CalculateActivity.class);
//                //startActivity(intent);
//                return;
//            case R.id.btn_introduce:
//                return;
//            case R.id.btn_logout:
//                signOut();
//                Toast.makeText(MenuActivity.this,"로그아웃 되셨습니다.",Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(MenuActivity.this,LoginActivity.class));
//                return;
        }
//
//    }
}
