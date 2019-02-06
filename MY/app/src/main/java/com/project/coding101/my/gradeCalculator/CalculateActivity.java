package com.project.coding101.my.gradeCalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.project.coding101.my.R;

public class CalculateActivity extends AppCompatActivity {
    TabLayout.Tab tab1;
    TabLayout.Tab tab2;
    TabLayout.Tab tab3;
    TabLayout.Tab tab4;

    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade_calculation);



        //자바 파일에서 어뎁터 생성
        //PagerAdapter pageradapter = new PagerAdapter(getSupportFragmentManager());

        //뷰 페이저 ID를 찾고, 뷰페이저 어뎁터랑 연결
        final ViewPager viewpager = findViewById(R.id.viewpager);
        //viewpager.setAdapter(pageradapter);

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

    }

}
