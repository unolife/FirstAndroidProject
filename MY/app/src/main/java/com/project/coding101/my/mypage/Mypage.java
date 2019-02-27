package com.project.coding101.my.mypage;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.coding101.my.R;
import com.project.coding101.my.User;

public class Mypage extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private DatabaseReference userDB;
    private FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

    TextView email, nickname, name, collagenum, tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        userDB = mDatabase.child("users").child(userId(currentUser.getEmail())).child("userInfo");

        email = findViewById(R.id.TextView_email);
        nickname = findViewById(R.id.TextView_nickname);
        name = findViewById(R.id.TextView_name);
        collagenum = findViewById(R.id.TextView_collagenum);
        tel = findViewById(R.id.TextView_tel);

        userDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User currentUser = dataSnapshot.getValue(User.class);

                email.setText(currentUser.email.toString());
                nickname.setText(currentUser.nickname.toString());
                name.setText(currentUser.username.toString());
                collagenum.setText(currentUser.collagenum.toString());
                tel.setText(currentUser.tel.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private String userId(String email){
        String ans ="";
        for(int i=0; i<email.length();i++) {
            char a =email.charAt(i);
            if(a!='.'&&a!='@') {
                ans +=a;
            }
        }
        return ans;
    }
}
