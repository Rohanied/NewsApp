package com.example.newsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel {

    @SerializedName("status")
    public String status;
    @SerializedName("totalArticles")
    public int totalArticles;
    @SerializedName("articles")
    public List<Article> articles=null;

    public void setStatus(String status){
        this.status=status;
    }

    public String getStatus(){
        return status;
    }

    public void setTotalArticles(int totalArticles){
        this.totalArticles=totalArticles;
    }

    public int getTotalArticles() {
        return totalArticles;
    }

    public void setArticles(List<Article> articles){
        this.articles=articles;
    }

    public List<Article> getArticles(){
        return articles;
    }
}
