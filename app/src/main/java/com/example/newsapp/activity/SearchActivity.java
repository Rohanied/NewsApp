package com.example.newsapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapp.R;
import com.example.newsapp.adapter.articleAdapter;
import com.example.newsapp.model.Article;
import com.example.newsapp.model.ResponseModel;
import com.example.newsapp.rests.APIClient;
import com.example.newsapp.rests.APIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.newsapp.activity.MainActivity.API_KEY;

public class SearchActivity extends AppCompatActivity {

    public static String keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        //TextView textView = (TextView) findViewById(R.id.keyword);
        Intent intent = getIntent();
         keyword = intent.getStringExtra("key");

        Toolbar toolbar =  findViewById(R.id.toolbar_search);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);




         TextView heading = (TextView) findViewById(R.id.heading);
         heading.setText("Search results for : "+keyword);

        final RecyclerView recyclerView = findViewById(R.id.rv_results);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        final APIInterface apiservice = APIClient.getClient().create(APIInterface.class);
        Call<ResponseModel> call = apiservice.getSearchResults("in",keyword,API_KEY);

        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(response.body().getStatus().equals("ok")){
                    List<Article> articleList = response.body().getArticles();
                    if(articleList.size()>0){
                        final articleAdapter adapter = new articleAdapter(articleList);
                        recyclerView.setAdapter(adapter);

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.v("tag", "failed in enqueue");

            }
        });

    }

    public void upHandler(View view) {
        this.finish();
    }
}
