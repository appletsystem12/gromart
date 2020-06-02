package com.milk.bread.bread_milk.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.milk.bread.bread_milk.R;
import com.milk.bread.bread_milk.adapter.ViewPagerAdapter;
import com.milk.bread.bread_milk.fragment.All_milk;
import com.milk.bread.bread_milk.fragment.FullCream;
import com.milk.bread.bread_milk.fragment.Low_fat;
import com.milk.bread.bread_milk.fragment.Other_Milk;
import com.milk.bread.bread_milk.fragment.Powder;
import com.milk.bread.bread_milk.fragment.Toned;

public class SubCategoryScreen extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk);

        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

    }
    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new All_milk(),"All Milk");
        viewPagerAdapter.addFragment(new FullCream(),"Full Cream");
        viewPagerAdapter.addFragment(new Low_fat(),"Low Fat");
        viewPagerAdapter.addFragment(new Other_Milk(),"Other Milk");
        viewPagerAdapter.addFragment(new Powder(),"Powder");
        viewPagerAdapter.addFragment(new Toned(),"Toned");
        viewPager.setAdapter(viewPagerAdapter);
    }
}