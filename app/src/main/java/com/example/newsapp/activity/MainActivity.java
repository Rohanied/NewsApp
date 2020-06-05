package com.example.newsapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.newsapp.R;
import com.example.newsapp.adapter.PageAdapter;
import com.example.newsapp.adapter.articleAdapter;
import com.example.newsapp.model.Article;
import com.example.newsapp.model.ResponseModel;
import com.example.newsapp.rests.APIClient;
import com.example.newsapp.rests.APIInterface;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


        final static String API_KEY="";

        public String keyword = null;
    EditText search_input;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            search_input = (EditText) findViewById(R.id.search_text);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.label_headlines));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.label_business));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.lable_entertainment));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.label_science));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.label_heath));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.label_sports));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.label_tech));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        final ViewPager viewPager = findViewById(R.id.view_pager);
        final PageAdapter adapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

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

    }

    public void SearchClick(View view) {
            keyword=search_input.getText().toString();
            Intent intent =new Intent(MainActivity.this,SearchActivity.class);
            intent.putExtra("key", keyword);
            startActivity(intent);
    }

}
