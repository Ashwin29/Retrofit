package com.winision.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiInterface apiClient = Client.getClient().create(ApiInterface.class);
        Call<List<Modal>> call = apiClient.getUserData();
        final RecyclerView recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        call.enqueue(new Callback<List<Modal>>() {
            @Override
            public void onResponse(Call<List<Modal>> call, Response<List<Modal>> response) {
                List<Modal> data = response.body();
                recyclerView.setAdapter(new DataAdapter(data, R.layout.cardholder, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Modal>> call, Throwable t) {

            }
        });
    }
}
