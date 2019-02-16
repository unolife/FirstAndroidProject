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

public class Fragment02 extends Fragment {


    public Fragment02(){

    }
    private FirebaseAuth mAuth;
    private DatabaseReference database;
    private FirebaseUser currentUser = mAuth.getInstance().getCurrentUser();
    DatabaseReference gradeDB;

    EditText edittext_corescoreinput,edittext_one_one,edittext_one_two,edittext_two_one,edittext_two_two,edittext_three_one,edittext_three_two,edittext_four_one,edittext_four_two;
    ToggleButton btn_coreone,btn_coretwo,btn_corethree,btn_corefour,btn_corescoreinput;
    TextView textview_coreresult;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view2 = inflater.inflate(R.layout.frag02,container,false);

        database = FirebaseDatabase.getInstance().getReference();
        gradeDB = database.child("users").child(userId(currentUser.getEmail())).child("gradeCalculator").child("핵심교양");

        edittext_corescoreinput = view2.findViewById(R.id.corescoreinput);
        edittext_one_one = view2.findViewById(R.id.EditText_one_one);
        edittext_one_two = view2.findViewById(R.id.EditText_one_two);
        edittext_two_one = view2.findViewById(R.id.EditText_two_one);
        edittext_two_two = view2.findViewById(R.id.EditText_two_two);
        edittext_three_one = view2.findViewById(R.id.EditText_three_one);
        edittext_three_two = view2.findViewById(R.id.EditText_three_two);
        edittext_four_one = view2.findViewById(R.id.EditText_four_one);
        edittext_four_two = view2.findViewById(R.id.EditText_four_two);
        btn_coreone = view2.findViewById(R.id.btn_coreown);
        btn_coretwo = view2.findViewById(R.id.btn_coretwo);
        btn_corethree = view2.findViewById(R.id.btn_corethree);
        btn_corefour = view2.findViewById(R.id.btn_corefour);
        btn_corescoreinput = view2.findViewById(R.id.btn_corescoreinput);
        textview_coreresult = view2.findViewById(R.id.TextView_coreresult);

        initData();

        //데이터 저장

        btn_corescoreinput.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    gradeDB.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Grade grade = dataSnapshot.getValue(Grade.class);
                            try{grade.input = Integer.parseInt(edittext_corescoreinput.getText().toString());
                                grade.total = grade.input - (grade.one_one + grade.one_two + grade.two_one
                                        + grade.two_two + grade.three_one + grade.three_two + grade.four_one + grade.four_one);}catch (Exception e){grade.input=0;}
                            gradeDB.setValue(grade);
                            textview_coreresult.setText(grade.total.toString());
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {}
                    });
                    edittext_corescoreinput.setEnabled(false);
                    edittext_corescoreinput.setTextColor(Color.BLACK);
                    edittext_corescoreinput.setBackgroundResource(R.drawable.edit_background);//DB읽어오기 수정!
                    edittext_one_one.requestFocus();
                }else{
                    edittext_corescoreinput.setBackgroundResource(R.drawable.edit_background_on);
                    edittext_corescoreinput.setEnabled(true);
                }
            }
        });

        btn_coreone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

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
                            textview_coreresult.setText(grade.total.toString());
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

        btn_coretwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

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
                            textview_coreresult.setText(grade.total.toString());
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
        btn_corethree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

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
                            textview_coreresult.setText(grade.total.toString());
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

        btn_corefour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

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
                            textview_coreresult.setText(grade.total.toString());
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

        return  view2;
    }

    private void initData(){
        gradeDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Grade grade = dataSnapshot.getValue(Grade.class);
                try{edittext_corescoreinput.setText(grade.input.toString());
                    edittext_corescoreinput.setTextColor(Color.BLACK);
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
                    textview_coreresult.setText(grade.total.toString());}catch (NullPointerException e){}
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
