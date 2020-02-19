package com.willy.will.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.willy.will.calander.view.fragmentCalander;
import com.willy.will.main.view.fragmentMain;

public class viewPagerAdapter extends FragmentPagerAdapter {

    public viewPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return 2;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: default:
                fragmentMain tmpfragmentMain = fragmentMain.getInstance(0);
                return tmpfragmentMain;

            case 1:
                return fragmentCalander.newInstance(1, "Page # 2");
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}
