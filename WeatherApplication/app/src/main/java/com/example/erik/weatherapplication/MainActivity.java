package com.example.erik.weatherapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.erik.weatherapplication.adapter.ViewPagerCustomAdapter;
import com.example.erik.weatherapplication.fragment.HistoryFragment;
import com.example.erik.weatherapplication.fragment.SearchFragment;
import com.example.erik.weatherapplication.fragment.WeatherFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment[] fragments = new Fragment[3];
        SearchFragment searchFragment = new SearchFragment();
        WeatherFragment weatherFragment = new WeatherFragment();
        HistoryFragment historyFragment = new HistoryFragment();
        searchFragment.setWeatherCallBack(weatherFragment);
        searchFragment.setHistoryCallBack(historyFragment);

        fragments[0] = weatherFragment;
        fragments[1] = searchFragment;
        fragments[2] = historyFragment;


        ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new ViewPagerCustomAdapter(this.getSupportFragmentManager(),fragments));
        viewPager.setOffscreenPageLimit(3);
    }
}
