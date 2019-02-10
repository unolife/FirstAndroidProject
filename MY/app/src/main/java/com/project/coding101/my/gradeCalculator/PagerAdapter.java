package com.project.coding101.my.gradeCalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class PagerAdapter extends FragmentPagerAdapter {


    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0:
                Fragment01 frag01 = new Fragment01();
                return frag01;
            case 1:
                Fragment02 frag02 = new Fragment02();
                return frag02;
            case 2:
                Fragment03 frag03 = new Fragment03();
                return frag03;
            case 3:
                Fragment04 frag04 = new Fragment04();
                return frag04;
            default:
                return null;
        }
    }

    private static int PAGE_NUMBER = 4;

    @Override
    public int getCount() {
        return PAGE_NUMBER;
    }

}
