package com.example.newsapp.model;

import com.google.gson.annotations.SerializedName;

public class SourceModel {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;

    public void setId(String id){
        this.id=id;
    }

    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
}
