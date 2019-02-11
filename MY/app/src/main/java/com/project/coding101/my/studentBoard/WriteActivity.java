package com.project.coding101.my.studentBoard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.coding101.my.R;


public class WriteActivity extends AppCompatActivity {

    private EditText input_title;
    private EditText input_content;
    private String title;
    private String content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        input_title = findViewById(R.id.title);
        input_content = findViewById(R.id.content);


        input_title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                title = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        input_content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                content = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Button soft_btn = (Button) findViewById(R.id.add_btn);
        soft_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext() , writeActivity.class);
                Intent intent = new Intent(v.getContext(), MainBoard.class);
                startActivity(intent);
            }
        });
    }
}
