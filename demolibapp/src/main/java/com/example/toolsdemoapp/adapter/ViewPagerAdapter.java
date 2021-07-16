package com.example.toolsdemoapp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.toolsdemoapp.fragment.TabFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter{

    private String tabsOptions[] = {"Tab 1", "Tab 2"};

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment.getInstance(position);
    }

    @Override
    public int getCount() {
        return tabsOptions.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabsOptions[position];
    }
}
