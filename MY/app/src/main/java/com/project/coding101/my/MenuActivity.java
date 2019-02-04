package com.project.coding101.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MenuActivity extends AppCompatActivity {
    // public void main(String args[]){}

    Button btn_calculate;
    Button btn_introduction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_calculate = findViewById(R.id.btn_calculate);
        btn_introduction=findViewById(R.id.btn_introduce);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MenuActivity.this,CalculateActivity.class);
                //startActivity(intent);
            }
        });




    }

}
