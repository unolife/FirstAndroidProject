package com.project.coding101.my.gradeCalculator;

import android.graphics.Color;
import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.project.coding101.my.R;

public class Fragment01 extends Fragment {

    EditText edittext_comscoreinput,edittext_one_one,edittext_one_two,edittext_two_one,edittext_two_two,edittext_three_one,edittext_three_two,edittext_four_one,edittext_four_two;
    ToggleButton btn_comone,btn_comtwo,btn_comthree,btn_comfour,btn_comscoreinput;
    TextView textview_comresult;

    Integer input=0,one_one=0,one_two=0,two_one=0,two_two=0,three_one=0,three_two=0,four_own=0,four_two=0;
    public Fragment01 (){
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view1 = inflater.inflate(R.layout.frag01,container,false);

        edittext_comscoreinput = view1.findViewById(R.id.comscoreinput);
        edittext_one_one = view1.findViewById(R.id.EditText_one_one);
        edittext_one_two = view1.findViewById(R.id.EditText_one_two);
        edittext_two_one = view1.findViewById(R.id.EditText_two_one);
        edittext_two_two = view1.findViewById(R.id.EditText_two_two);
        edittext_three_one = view1.findViewById(R.id.EditText_three_one);
        edittext_three_two = view1.findViewById(R.id.EditText_three_two);
        edittext_four_one = view1.findViewById(R.id.EditText_four_one);
        edittext_four_two = view1.findViewById(R.id.EditText_four_two);
        btn_comone = view1.findViewById(R.id.btn_comown);
        btn_comtwo = view1.findViewById(R.id.btn_comtwo);
        btn_comthree = view1.findViewById(R.id.btn_comthree);
        btn_comfour = view1.findViewById(R.id.btn_comfour);
        btn_comscoreinput = view1.findViewById(R.id.btn_comscoreinput);
        textview_comresult = view1.findViewById(R.id.TextView_comresult);

        edittext_comscoreinput.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {input =Integer.parseInt(s.toString());}catch (Exception e){input=0;}
            }
            public void afterTextChanged(Editable s) {}
        });
        edittext_one_one.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { one_one =Integer.parseInt(s.toString()); }catch (Exception e){one_one=0;}
            }
            public void afterTextChanged(Editable s) {}
        });
        edittext_one_two.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {one_two =Integer.parseInt(s.toString());}catch (Exception e){one_two=0;}
            }
            public void afterTextChanged(Editable s) {}
        });
        edittext_two_one.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{two_one =Integer.parseInt(s.toString());}catch (Exception e){two_one=0;}
            }
            public void afterTextChanged(Editable s) {}
        });
        edittext_two_two.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {two_two =Integer.parseInt(s.toString());}catch (Exception e){two_two=0;}

            }
            public void afterTextChanged(Editable s) {}
        });

        edittext_three_one.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {three_one =Integer.parseInt(s.toString());}catch (Exception e){three_one=0;}
            }
            public void afterTextChanged(Editable s) {}
        });
        edittext_three_two.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { three_two =Integer.parseInt(s.toString()); }catch (Exception e){three_two=0;}
            }
            public void afterTextChanged(Editable s) {}
        });
        edittext_four_one.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {four_own =Integer.parseInt(s.toString());}catch (Exception e){four_own=0;}
            }
            public void afterTextChanged(Editable s) {}
        });
        edittext_four_two.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try { four_two =Integer.parseInt(s.toString()); }catch (Exception e){four_two=0;}
            }
            public void afterTextChanged(Editable s) {}
        });

        btn_comscoreinput.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edittext_comscoreinput.setEnabled(false);
                    edittext_comscoreinput.setTextColor(Color.BLACK);
                    edittext_comscoreinput.setBackgroundResource(R.drawable.edit_background);
                    textview_comresult.setText(Calculation());
                    edittext_one_one.requestFocus();
                }else{
                    edittext_comscoreinput.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_comscoreinput.setEnabled(true);
                }
            }
        });

        btn_comone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edittext_one_one.setEnabled(false);
                    edittext_one_one.setTextColor(Color.BLACK);
                    edittext_one_one.setBackgroundResource(R.drawable.edit_background);
                    edittext_one_two.setEnabled(false);
                    edittext_one_two.setTextColor(Color.BLACK);
                    edittext_one_two.setBackgroundResource(R.drawable.edit_background);
                    edittext_two_one.requestFocus();
                    textview_comresult.setText(Calculation());
                }else{
                    edittext_one_one.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_one_one.setEnabled(true);
                    edittext_one_two.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_one_two.setEnabled(true);
                }
            }
        });

        btn_comtwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edittext_two_one.setEnabled(false);
                    edittext_two_one.setTextColor(Color.BLACK);
                    edittext_two_one.setBackgroundResource(R.drawable.edit_background);
                    edittext_two_two.setEnabled(false);
                    edittext_two_two.setTextColor(Color.BLACK);
                    edittext_two_two.setBackgroundResource(R.drawable.edit_background);
                    edittext_three_one.requestFocus();
                    textview_comresult.setText(Calculation());
                }else{
                    edittext_two_one.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_two_one.setEnabled(true);
                    edittext_two_two.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_two_two.setEnabled(true);
                }
            }
        });
        btn_comthree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edittext_three_one.setEnabled(false);
                    edittext_three_one.setTextColor(Color.BLACK);
                    edittext_three_one.setBackgroundResource(R.drawable.edit_background);
                    edittext_three_two.setEnabled(false);
                    edittext_three_two.setTextColor(Color.BLACK);
                    edittext_three_two.setBackgroundResource(R.drawable.edit_background);
                    edittext_four_one.requestFocus();
                    textview_comresult.setText(Calculation());
                }else{
                    edittext_three_one.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_three_one.setEnabled(true);
                    edittext_three_two.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_three_two.setEnabled(true);
                }
            }
        });

        btn_comfour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edittext_four_one.setEnabled(false);
                    edittext_four_one.setTextColor(Color.BLACK);
                    edittext_four_one.setBackgroundResource(R.drawable.edit_background);
                    edittext_four_two.setEnabled(false);
                    edittext_four_two.setTextColor(Color.BLACK);
                    edittext_four_two.setBackgroundResource(R.drawable.edit_background);
                    btn_comscoreinput.setText(Calculation());
                }else{
                    edittext_four_one.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_four_one.setEnabled(true);
                    edittext_four_two.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_four_two.setEnabled(true);
                }
            }
        });

        return  view1;
    }
    public String Calculation(){
        Integer ans =input -(one_one+one_two+two_one+
        two_two+three_one+three_two+four_own+four_two);
        return ans.toString();
    }

}
