package com.project.coding101.my;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.coding101.my.findEmalPassword.FindActivity;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "EmailPassword";
    private FirebaseAuth mAuth;

    TextInputEditText TextInputEditText_ID, TextInputEditText_password;
    Button Button_Iogin, Button_join, Button_find;
    String id, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputEditText_ID = findViewById(R.id.TextInputEditText_ID);
        TextInputEditText_password = findViewById(R.id.TextInputEditText_password);

        Button_Iogin = findViewById(R.id.Button_Iogin);
        Button_join = findViewById(R.id.Button_join);
        Button_find = findViewById(R.id.Button_find);

        mAuth = FirebaseAuth.getInstance();

        TextInputEditText_ID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                id = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        TextInputEditText_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password = s.toString();
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });

        Button_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });
        Button_Iogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(id, password);

            }
        });
        Button_find.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, FindActivity.class);
                startActivity(intent);
            }
        });

    }
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void signIn(String email, String password) {

        if (!validateForm()) {
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                            startActivity(intent);
                            finish();
                            //updateUI(user);
                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "아이디와 비밀번호를 다시 확인해주세요.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }
    private boolean validateForm() {
        boolean valid = true;

        String email = TextInputEditText_ID.getText().toString();
        if (TextUtils.isEmpty(email)) {
            TextInputEditText_ID.setError("아이디를 작성해주세요.");
            valid = false;
        } else {
            TextInputEditText_ID.setError(null);
        }

        String password = TextInputEditText_password.getText().toString();
        if (TextUtils.isEmpty(password)) {
            TextInputEditText_password.setError("비밀번호를 작성해주세요.");
            valid = false;
        } else {
            TextInputEditText_password.setError(null);
        }
        return valid;
    }

}
