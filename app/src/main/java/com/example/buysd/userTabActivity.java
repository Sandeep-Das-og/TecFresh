package com.example.buysd;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class userTabActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_tab);

        TabLayout tabLayout = findViewById(R.id.tabBar);
        TabItem customerTab = findViewById(R.id.customer_tab);
        TabItem shopkeeperTab = findViewById(R.id.shopkeeper_tab);

        final ViewPager viewPager = findViewById(R.id.view_pager);

        pagerAdapter PagerAdapter = new pagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

        viewPager.setAdapter(PagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }


}
