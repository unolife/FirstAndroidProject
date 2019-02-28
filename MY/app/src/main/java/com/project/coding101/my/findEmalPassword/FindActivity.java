package com.project.coding101.my.findEmalPassword;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.project.coding101.my.R;

public class FindActivity extends AppCompatActivity {
    TabLayout.Tab findEmail, findPassword;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        //탭 설정
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        findEmail = tabLayout.newTab();
        tabLayout.addTab(findEmail.setText("이메일 찾기"));
        findPassword = tabLayout.newTab();
        tabLayout.addTab(findPassword.setText("비밀번호 찾기"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // 어댑터 생성
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());

        // 뷰 페이저
        mViewPager = (ViewPager) findViewById(R.id.container);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }
}