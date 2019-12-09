package com.example.myfirstandroiddemo;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class MyFragmentAdapter extends FragmentStatePagerAdapter {
    public List<Fragment> list;
    public List<String> titles;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> list, List<String> titles){
        super(fm);
        this.list = list;
        this.titles = titles;
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Fragment getItem(int postion){
        return list.get(postion);
    }

    @Override
    public CharSequence getPageTitle(int postion){
        return titles.get(postion);
    }
}
