package com.madhumankatha.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<Covid> covidArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.covid19api.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        
        apiService.getCovid().enqueue(new Callback<Summary>() {
            @Override
            public void onResponse(Call<Summary> call, Response<Summary> response) {
                Log.d("TAG", "onResponse: " + response.message());
                Log.d("TAG", "onResponse: " + response.code());
                if (response.isSuccessful()){
                    covidArrayList = response.body().getCovidArrayList();
                    Log.d("TAG", "onResponse: " + covidArrayList.get(0).getCountryName());
                    Log.d("TAG", "onResponse: " + covidArrayList.get(0).getNewCases());
                    Log.d("TAG", "onResponse: " + covidArrayList.get(0).getTotalCases());
                    adapter = new Adapter(covidArrayList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Summary> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Check internet!!!", Toast.LENGTH_SHORT).show();
                Log.d("TAG", "onFailure: " + t.getMessage());
                Log.d("TAG", "onFailure: " + t.toString());
            }
        });
        
    }
}