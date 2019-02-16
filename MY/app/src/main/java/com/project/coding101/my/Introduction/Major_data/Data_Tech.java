package com.project.coding101.my.Introduction.Major_data;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.coding101.my.R;

public class Data_Tech extends AppCompatActivity implements View.OnClickListener{

    Data_frag1 frag1;
    Data_frag2 frag2;
    Data_frag3 frag3;
    FragmentManager fm;
    FragmentTransaction tran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__tech);

        Button intro_major2 = (Button)findViewById(R.id.intro_major2);
        Button intro_pro2 = (Button)findViewById(R.id.intro_pro2);
        Button curry2 = (Button)findViewById(R.id.curry2);

        intro_major2.setOnClickListener(this);
        intro_pro2.setOnClickListener(this);
        curry2.setOnClickListener(this);

        frag1 = new Data_frag1();
        frag2 = new Data_frag2();
        frag3 = new Data_frag3();
        setFrag(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.intro_major2:
                setFrag(0);
                break;
            case R.id.intro_pro2:
                setFrag(1);
                break;
            case R.id.curry2:
                setFrag(2);
                break;
        }
    }

    public void setFrag(int n){
        fm = getSupportFragmentManager();
        tran = fm.beginTransaction();

        switch (n){
            case 0:
                tran.replace(R.id.main_frame2, frag1);
                tran.commit();
                break;
            case 1:
                tran.replace(R.id.main_frame2, frag2);
                tran.commit();
                break;
            case 2:
                tran.replace(R.id.main_frame2, frag3);
                tran.commit();
                break;
        }
    }

}
