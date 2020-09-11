package com.madhumankatha.covid19tracker;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/summary")
    Call<Summary> getCovid();
}
