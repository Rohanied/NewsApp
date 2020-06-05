package com.example.newsapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.newsapp.fragments.Sports;
import com.example.newsapp.fragments.Technology;
import com.example.newsapp.fragments.TopHeadlines;
import com.example.newsapp.fragments.Businesss;
import com.example.newsapp.fragments.Entertainment;
import com.example.newsapp.fragments.Health;
import com.example.newsapp.fragments.Science;

public class PageAdapter extends FragmentStatePagerAdapter {

    int NumberOfTabs;

    public PageAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.NumberOfTabs=numberOfTabs;

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new TopHeadlines();
            case 1: return new Businesss();
            case 2: return new Entertainment();
            case 3: return new Health();
            case 4: return new Science();
            case 5: return new Sports();
            case 6: return new Technology();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return NumberOfTabs;
    }
}
