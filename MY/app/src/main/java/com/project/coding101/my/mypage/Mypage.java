package com.project.coding101.my.mypage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.coding101.my.R;

public class Mypage extends AppCompatActivity {

    private FirebaseAuth mAuth;

    TextView email, nickname, name, collagenum, tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        email = findViewById(R.id.TextView_email);
        nickname = findViewById(R.id.TextView_nickname);
        name = findViewById(R.id.TextView_name);
        collagenum = findViewById(R.id.TextView_collagenum);
        tel = findViewById(R.id.TextView_tel);


        mAuth = FirebaseAuth.getInstance();

        FirebaseUser u1 = mAuth.getCurrentUser();
        email.setText(u1.getEmail());
        tel.setText(u1.getPhoneNumber());
    }
}
