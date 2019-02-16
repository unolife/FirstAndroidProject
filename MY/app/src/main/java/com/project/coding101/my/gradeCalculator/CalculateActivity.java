package com.project.coding101.my.gradeCalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.coding101.my.R;

public class CalculateActivity extends AppCompatActivity {
    TabLayout.Tab tab1, tab2, tab3, tab4;
    TextView tot, left;
    private FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    private DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference gradeDB;


    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade_calculation);

        gradeDB = database.child("users").child(userId(currentUser.getEmail())).child("gradeCalculator");

        tot = findViewById(R.id.TextView_totalgrade);
        left = findViewById(R.id.TextView_leftgrade);

        //자바 파일에서 어뎁터 생성
        PagerAdapter pageradapter = new PagerAdapter(getSupportFragmentManager());

        //뷰 페이저 ID를 찾고, 뷰페이저 어뎁터랑 연결
        final ViewPager viewpager = findViewById(R.id.viewpager);
        viewpager.setAdapter(pageradapter);

        //탭설정
        final TabLayout tab = findViewById(R.id.tabs);
        tab1 = tab.newTab();
        tab.addTab(tab1.setText("공통교양"));
        tab2 = tab.newTab();
        tab.addTab(tab2.setText("핵심교양"));
        tab3 = tab.newTab();
        tab.addTab(tab3.setText("학문기초"));
        tab4 = tab.newTab();
        tab.addTab(tab4.setText("전공"));
        tab.setTabGravity(tab.GRAVITY_FILL);

        //탭싱크화
        tab.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewpager));
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

        gradeDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Grade grade1 = dataSnapshot.child("공통교양").getValue(Grade.class);
                Grade grade2 = dataSnapshot.child("핵심교양").getValue(Grade.class);
                Grade grade3 = dataSnapshot.child("학문기초").getValue(Grade.class);
                Grade grade4 = dataSnapshot.child("전공").getValue(Grade.class);
                TotalGrade totgd = dataSnapshot.child("total").getValue(TotalGrade.class);
                totgd.totalgd = grade1.input + grade2.input + grade3.input + grade4.input;
                totgd.leftgd = grade1.total + grade2.total + grade3.total + grade4.total;
                tot.setText(totgd.totalgd.toString());
                left.setText(totgd.leftgd.toString());
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
