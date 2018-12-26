package com.example.erik.weatherapplication.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class ViewPagerCustomAdapter extends FragmentPagerAdapter {
    private final Fragment[] fragments;

    public ViewPagerCustomAdapter(FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return this.fragments[i];
    }

    @Override
    public int getCount() {
        return this.fragments.length;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "WEATHER";
            case 1:
                return "SEARCH";
            case 2:
                return "HISTORY";
            default:
                return null;
        }
    }
}
