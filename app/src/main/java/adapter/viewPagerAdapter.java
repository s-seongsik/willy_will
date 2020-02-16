package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;

import com.example.willy_will.R;
import com.example.willy_will.fragmentCalander;
import com.example.willy_will.fragmentMain;

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
                fragmentMain tmpfragmentMain = fragmentMain.newInstance(0, "Page # 1", new mainListAdapter());
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
