package com.project.coding101.my.Introduction.Major_soft;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.coding101.my.R;

public class Application_Soft extends AppCompatActivity implements View.OnClickListener{

    Soft_frag1 frag1;
    Soft_frag2 frag2;
    Soft_frag3 frag3;
    FragmentManager fm;
    FragmentTransaction tran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application__soft);

        Button intro_major = (Button)findViewById(R.id.intro_major);
        Button intro_pro = (Button)findViewById(R.id.intro_pro);
        Button curry = (Button)findViewById(R.id.curry);

        intro_major.setOnClickListener(this);
        intro_pro.setOnClickListener(this);
        curry.setOnClickListener(this);

        frag1 = new Soft_frag1();
        frag2 = new Soft_frag2();
        frag3 = new Soft_frag3();
        setFrag(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.intro_major:
                setFrag(0);
                break;
            case R.id.intro_pro:
                setFrag(1);
                break;
            case R.id.curry:
                setFrag(2);
                break;
        }
    }

    public void setFrag(int n){
        fm = getSupportFragmentManager();
        tran = fm.beginTransaction();

        switch (n){
            case 0:
                tran.replace(R.id.main_frame, frag1);
                tran.commit();
                break;
            case 1:
                tran.replace(R.id.main_frame, frag2);
                tran.commit();
                break;
            case 2:
                tran.replace(R.id.main_frame, frag3);
                tran.commit();
                break;
        }
    }
}
