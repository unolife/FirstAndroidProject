package com.project.coding101.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.coding101.my.Introduction.IntroActivity;
import com.project.coding101.my.gradeCalculator.CalculateActivity;
import com.project.coding101.my.studentBoard.MainBoard;


public class MenuActivity extends AppCompatActivity{

    private FirebaseAuth mAuth;

    Button btn_logout;
    TextView user;
    Button btn_introduce, btn_calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_logout = findViewById(R.id.btn_logout);
        user = findViewById(R.id.TextView_user);

        mAuth = FirebaseAuth.getInstance();


        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그아웃 기능
                mAuth.signOut();
                Toast.makeText(MenuActivity.this,"로그아웃 되셨습니다.",Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(MenuActivity.this,LoginActivity.class));

            }
        });

        FirebaseUser u1 = mAuth.getCurrentUser();
        user.setText(u1.getEmail()+"님 안녕하세요!");
        //DB연동 후에 닉네임으로 바꿀 것

        btn_introduce = (Button)findViewById(R.id.btn_introduce);
        btn_introduce.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(intent);
            }
        });
        btn_introduce = (Button)findViewById(R.id.btn_board);
        btn_introduce.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainBoard.class);
                startActivity(intent);
            }
        });
        btn_calculate = (Button)findViewById(R.id.btn_calculate);
        btn_calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CalculateActivity.class);
                startActivity(intent);
            }
        });


    }
}