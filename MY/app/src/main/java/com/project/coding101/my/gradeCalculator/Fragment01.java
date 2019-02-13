package com.project.coding101.my.gradeCalculator;

import android.graphics.Color;
import android.os.Bundle;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.coding101.my.R;

public class Fragment01 extends Fragment {

    private FirebaseAuth mAuth;
    private DatabaseReference database;
    private FirebaseUser currentUser = mAuth.getInstance().getCurrentUser();
    DatabaseReference gradeDB;

    EditText edittext_comscoreinput,edittext_one_one,edittext_one_two,edittext_two_one,edittext_two_two,edittext_three_one,edittext_three_two,edittext_four_one,edittext_four_two;
    ToggleButton btn_comone,btn_comtwo,btn_comthree,btn_comfour,btn_comscoreinput;
    TextView textview_comresult;

    public Fragment01 (){
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view1 = inflater.inflate(R.layout.frag01,container,false);

        database = FirebaseDatabase.getInstance().getReference();
        gradeDB = database.child("users").child(userId(currentUser.getEmail())).child("gradeCalculator");

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

        //데이터 저장

        btn_comscoreinput.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    gradeDB.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Grade grade = dataSnapshot.getValue(Grade.class);
                            grade.input = Integer.parseInt(edittext_comscoreinput.getText().toString());
                            gradeDB.setValue(grade);
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {}
                    });
                    edittext_comscoreinput.setEnabled(false);
                    edittext_comscoreinput.setTextColor(Color.BLACK);
                    edittext_comscoreinput.setBackgroundResource(R.drawable.edit_background);
//                    textview_comresult.setText(Calculation());//DB읽어오기 수정!
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
                    gradeDB.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Grade grade = dataSnapshot.getValue(Grade.class);
                            grade.one_one = Integer.parseInt(edittext_one_one.getText().toString());
                            grade.one_two = Integer.parseInt(edittext_one_two.getText().toString());
                            gradeDB.setValue(grade);
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {}
                    });
                    edittext_one_one.setEnabled(false);
                    edittext_one_one.setTextColor(Color.BLACK);
                    edittext_one_one.setBackgroundResource(R.drawable.edit_background);
                    edittext_one_two.setEnabled(false);
                    edittext_one_two.setTextColor(Color.BLACK);
                    edittext_one_two.setBackgroundResource(R.drawable.edit_background);
                    edittext_two_one.requestFocus();
//                    textview_comresult.setText(Calculation());
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
                    gradeDB.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Grade grade = dataSnapshot.getValue(Grade.class);
                            grade.two_one = Integer.parseInt(edittext_two_one.getText().toString());
                            grade.two_two = Integer.parseInt(edittext_two_two.getText().toString());
                            gradeDB.setValue(grade);
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {}
                    });

//                    database.child("users").child(userId(currentUser.getEmail())).child("gradeCalculator").setValue(grade);
                    edittext_two_one.setEnabled(false);
                    edittext_two_one.setTextColor(Color.BLACK);
                    edittext_two_one.setBackgroundResource(R.drawable.edit_background);
                    edittext_two_two.setEnabled(false);
                    edittext_two_two.setTextColor(Color.BLACK);
                    edittext_two_two.setBackgroundResource(R.drawable.edit_background);
                    edittext_three_one.requestFocus();
//                    textview_comresult.setText(Calculation());
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
                    gradeDB.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Grade grade = dataSnapshot.getValue(Grade.class);
                            grade.three_one = Integer.parseInt(edittext_three_one.getText().toString());
                            grade.three_two = Integer.parseInt(edittext_three_two.getText().toString());
                            gradeDB.setValue(grade);
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {}
                    });

//                    database.child("users").child(userId(currentUser.getEmail())).child("gradeCalculator").setValue(grade);
                    edittext_three_one.setEnabled(false);
                    edittext_three_one.setTextColor(Color.BLACK);
                    edittext_three_one.setBackgroundResource(R.drawable.edit_background);
                    edittext_three_two.setEnabled(false);
                    edittext_three_two.setTextColor(Color.BLACK);
                    edittext_three_two.setBackgroundResource(R.drawable.edit_background);
                    edittext_four_one.requestFocus();
//                    textview_comresult.setText();
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
                    gradeDB.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Grade grade = dataSnapshot.getValue(Grade.class);
                            grade.four_one = Integer.parseInt(edittext_four_one.getText().toString());
                            grade.four_two = Integer.parseInt(edittext_four_two.getText().toString());
                            gradeDB.setValue(grade);
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {}
                    });

//                    database.child("users").child(userId(currentUser.getEmail())).child("gradeCalculator").setValue(grade);
                    edittext_four_one.setEnabled(false);
                    edittext_four_one.setTextColor(Color.BLACK);
                    edittext_four_one.setBackgroundResource(R.drawable.edit_background);
                    edittext_four_two.setEnabled(false);
                    edittext_four_two.setTextColor(Color.BLACK);
                    edittext_four_two.setBackgroundResource(R.drawable.edit_background);
//                    btn_comscoreinput.setText();
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
//    public String Calculation(){
//        Integer ans =input -(one_one+one_two+two_one+
//        two_two+three_one+three_two+four_one+four_two);
//        return ans.toString();
//    }

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
