package com.project.coding101.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CreateActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private String TAG = "Email, PassWord";

    EditText email_textfield,password_textfield ;

    Button btn_join, btn_emailauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createacount);

        email_textfield = findViewById(R.id.EditText_Email);
        password_textfield = findViewById(R.id.EditText_Password);
        btn_join = findViewById(R.id.Button_join);
        btn_emailauth = findViewById(R.id.btn_emailauth);
        mAuth = FirebaseAuth.getInstance();

        btn_join.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createAccount(email_textfield.getText().toString(),password_textfield.getText().toString());
            }
        });

        btn_emailauth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendEmailVerification();
            }
        });
    }

    private void createAccount(String email, String password){

        if(!validateForm()){return;}

        mAuth.createUserWithEmailAndPassword(email, password )
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(CreateActivity.this, "회원가입을 성공하셨습니다.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(CreateActivity.this,LoginActivity.class));
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(CreateActivity.this, "회원가입 실패",Toast.LENGTH_SHORT).show();
                            //에러 두가지 경우 예외처리하기
                        }
                    }
                });
    }
    private void sendEmailVerification() {
        findViewById(R.id.btn_emailauth).setEnabled(false);

        final FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification().addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        btn_emailauth.setEnabled(true);

                        if (task.isSuccessful()) {
                            Toast.makeText(CreateActivity.this, user.getEmail()+"로 이메일 인증을 보냈습니다.", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.e(TAG, "sendEmailVerification", task.getException());
                            Toast.makeText(CreateActivity.this, "이메일 전송을 실패하였습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private boolean validateForm(){
        boolean valid =true;

        String email = email_textfield.getText().toString();
        if(TextUtils.isEmpty(email)){
            email_textfield.setError("필수입력 항목입니다.");
            valid =false;
        }else{
            email_textfield.setError(null);
        }

        String password = password_textfield.getText().toString();
        if(TextUtils.isEmpty(password)){
            password_textfield.setError("필수입력 항목입니다.");
            valid =false;
        }else{
            password_textfield.setError(null);
        }
        return valid;
    }

}
