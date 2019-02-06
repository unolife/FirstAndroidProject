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


public class MenuActivity extends AppCompatActivity{

    private FirebaseAuth mAuth;

    Button btn_logout;
    TextView user;

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


    }
}
