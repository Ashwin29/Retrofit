package com.winision.sampleapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//https://jsonplaceholder.typicode.com/posts
public interface ApiInterface {
    @GET("posts/")
    Call <List<Modal>> getUserData();
}
