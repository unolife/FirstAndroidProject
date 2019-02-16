package com.project.coding101.my.gradeCalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.coding101.my.R;

public class Fragment03 extends Fragment {


    public Fragment03(){

    }
    private FirebaseAuth mAuth;
    private DatabaseReference database;
    private FirebaseUser currentUser = mAuth.getInstance().getCurrentUser();
    DatabaseReference gradeDB;

    EditText edittext_basescoreinput,edittext_one_one,edittext_one_two,edittext_two_one,edittext_two_two,edittext_three_one,edittext_three_two,edittext_four_one,edittext_four_two;
    ToggleButton btn_baseone,btn_basetwo,btn_basethree,btn_basefour,btn_basescoreinput;
    TextView textview_baseresult;
    String total;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view3 = inflater.inflate(R.layout.frag03,container,false);

        database = FirebaseDatabase.getInstance().getReference();
        gradeDB = database.child("users").child(userId(currentUser.getEmail())).child("gradeCalculator").child("학문기초");

        edittext_basescoreinput = view3.findViewById(R.id.basescoreinput);
        edittext_one_one = view3.findViewById(R.id.EditText_one_one);
        edittext_one_two = view3.findViewById(R.id.EditText_one_two);
        edittext_two_one = view3.findViewById(R.id.EditText_two_one);
        edittext_two_two = view3.findViewById(R.id.EditText_two_two);
        edittext_three_one = view3.findViewById(R.id.EditText_three_one);
        edittext_three_two = view3.findViewById(R.id.EditText_three_two);
        edittext_four_one = view3.findViewById(R.id.EditText_four_one);
        edittext_four_two = view3.findViewById(R.id.EditText_four_two);
        btn_baseone = view3.findViewById(R.id.btn_baseown);
        btn_basetwo = view3.findViewById(R.id.btn_basetwo);
        btn_basethree = view3.findViewById(R.id.btn_basethree);
        btn_basefour = view3.findViewById(R.id.btn_basefour);
        btn_basescoreinput = view3.findViewById(R.id.btn_basescoreinput);
        textview_baseresult = view3.findViewById(R.id.TextView_baseresult);

        initData();

        //데이터 저장

        btn_basescoreinput.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    gradeDB.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Grade grade = dataSnapshot.getValue(Grade.class);
                            try{grade.input = Integer.parseInt(edittext_basescoreinput.getText().toString());
                                grade.total = grade.input - (grade.one_one + grade.one_two + grade.two_one
                                        + grade.two_two + grade.three_one + grade.three_two + grade.four_one + grade.four_one);}catch (Exception e){grade.input=0;}
                            gradeDB.setValue(grade);
                            textview_baseresult.setText(grade.total.toString());
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {}
                    });
                    edittext_basescoreinput.setEnabled(false);
                    edittext_basescoreinput.setTextColor(Color.BLACK);
                    edittext_basescoreinput.setBackgroundResource(R.drawable.edit_background);//DB읽어오기 수정!
                    edittext_one_one.requestFocus();
                }else{
                    edittext_basescoreinput.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_basescoreinput.setEnabled(true);
                }
            }
        });

        btn_baseone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    gradeDB.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Grade grade = dataSnapshot.getValue(Grade.class);
                            try{grade.one_one = Integer.parseInt(edittext_one_one.getText().toString());
                                grade.one_two = Integer.parseInt(edittext_one_two.getText().toString());
                                grade.total = grade.input - (grade.one_one + grade.one_two + grade.two_one
                                        + grade.two_two + grade.three_one + grade.three_two + grade.four_one + grade.four_one);}
                            catch (Exception e){grade.one_one=0; grade.one_two=0;}
                            gradeDB.setValue(grade);
                            textview_baseresult.setText(grade.total.toString());
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
                }else{
                    edittext_one_one.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_one_one.setEnabled(true);
                    edittext_one_two.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_one_two.setEnabled(true);
                }
            }
        });

        btn_basetwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    gradeDB.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Grade grade = dataSnapshot.getValue(Grade.class);
                            try{grade.two_one = Integer.parseInt(edittext_two_one.getText().toString());
                                grade.two_two = Integer.parseInt(edittext_two_two.getText().toString());
                                grade.total = grade.input - (grade.one_one + grade.one_two + grade.two_one
                                        + grade.two_two + grade.three_one + grade.three_two + grade.four_one + grade.four_one);}
                            catch (Exception e){grade.two_one=0; grade.two_two=0;}
                            gradeDB.setValue(grade);
                            textview_baseresult.setText(grade.total.toString());
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {}
                    });

                    edittext_two_one.setEnabled(false);
                    edittext_two_one.setTextColor(Color.BLACK);
                    edittext_two_one.setBackgroundResource(R.drawable.edit_background);
                    edittext_two_two.setEnabled(false);
                    edittext_two_two.setTextColor(Color.BLACK);
                    edittext_two_two.setBackgroundResource(R.drawable.edit_background);
                    edittext_three_one.requestFocus();
                }else{
                    edittext_two_one.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_two_one.setEnabled(true);
                    edittext_two_two.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_two_two.setEnabled(true);
                }
            }
        });
        btn_basethree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    gradeDB.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Grade grade = dataSnapshot.getValue(Grade.class);
                            try{grade.three_one = Integer.parseInt(edittext_three_one.getText().toString());
                                grade.three_two = Integer.parseInt(edittext_three_two.getText().toString());
                                grade.total = grade.input - (grade.one_one + grade.one_two + grade.two_one
                                        + grade.two_two + grade.three_one + grade.three_two + grade.four_one + grade.four_one);}
                            catch (Exception e ){
                                grade.three_one = 0;
                                grade.three_two = 0;
                            }
                            gradeDB.setValue(grade);
                            textview_baseresult.setText(grade.total.toString());
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {}
                    });

                    edittext_three_one.setEnabled(false);
                    edittext_three_one.setTextColor(Color.BLACK);
                    edittext_three_one.setBackgroundResource(R.drawable.edit_background);
                    edittext_three_two.setEnabled(false);
                    edittext_three_two.setTextColor(Color.BLACK);
                    edittext_three_two.setBackgroundResource(R.drawable.edit_background);
                    edittext_four_one.requestFocus();
                }else{
                    edittext_three_one.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_three_one.setEnabled(true);
                    edittext_three_two.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_three_two.setEnabled(true);
                }
            }
        });

        btn_basefour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    gradeDB.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Grade grade = dataSnapshot.getValue(Grade.class);
                            try{grade.four_one = Integer.parseInt(edittext_four_one.getText().toString());
                                grade.four_two = Integer.parseInt(edittext_four_two.getText().toString());}catch (Exception e){
                                grade.four_one=0; grade.four_two =0;
                            }
                            gradeDB.setValue(grade);
                            textview_baseresult.setText(grade.total.toString());
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {}
                    });
                    edittext_four_one.setEnabled(false);
                    edittext_four_one.setTextColor(Color.BLACK);
                    edittext_four_one.setBackgroundResource(R.drawable.edit_background);
                    edittext_four_two.setEnabled(false);
                    edittext_four_two.setTextColor(Color.BLACK);
                    edittext_four_two.setBackgroundResource(R.drawable.edit_background);
                }else{
                    edittext_four_one.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_four_one.setEnabled(true);
                    edittext_four_two.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_four_two.setEnabled(true);
                }
            }
        });

        return  view3;
    }

    private void initData(){
        gradeDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Grade grade = dataSnapshot.getValue(Grade.class);
                try{edittext_basescoreinput.setText(grade.input.toString());
                    edittext_basescoreinput.setTextColor(Color.BLACK);
                    edittext_one_one.setText(grade.one_one.toString());
                    edittext_one_one.setTextColor(Color.BLACK);
                    edittext_one_two.setText(grade.one_two.toString());
                    edittext_one_two.setTextColor(Color.BLACK);
                    edittext_two_one.setText(grade.getTwo_one().toString());
                    edittext_two_one.setTextColor(Color.BLACK);
                    edittext_two_two.setText(grade.getTwo_two().toString());
                    edittext_two_two.setTextColor(Color.BLACK);
                    edittext_three_one.setText(grade.getThree_one().toString());
                    edittext_three_one.setTextColor(Color.BLACK);
                    edittext_three_two.setText(grade.getThree_two().toString());
                    edittext_three_two.setTextColor(Color.BLACK);
                    edittext_four_one.setText(grade.getFour_one().toString());
                    edittext_four_one.setTextColor(Color.BLACK);
                    edittext_four_two.setText(grade.getFour_two().toString());
                    edittext_four_two.setTextColor(Color.BLACK);
                    textview_baseresult.setText(grade.total.toString());}catch (NullPointerException e){}
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
