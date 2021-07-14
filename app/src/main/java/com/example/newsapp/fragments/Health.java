package com.example.newsapp.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.OnRecyclerViewItemClickListener;
import com.example.newsapp.R;
import com.example.newsapp.activity.WebActivity;
import com.example.newsapp.adapter.articleAdapter;
import com.example.newsapp.model.Article;
import com.example.newsapp.model.ResponseModel;
import com.example.newsapp.rests.APIClient;
import com.example.newsapp.rests.APIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.newsapp.fragments.Businesss.API_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class Health extends Fragment implements OnRecyclerViewItemClickListener  {


    public Health() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_health, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView recyclerView = getActivity().findViewById(R.id.rv_health);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        final APIInterface apiservice = APIClient.getClient().create(APIInterface.class);
        Call<ResponseModel> call = apiservice.getLatestNews("in","health",API_KEY);

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
                Log.v("tag", "failed i enqueue");

            }
        });
    }

    @Override
    public void OnItemClick(Article article) {
        Log.d("Test","OnClicked");
        Intent intent = new Intent(getActivity(), WebActivity.class);
        intent.putExtra("url", article.getUrl());
        startActivity(intent);
    }
}
