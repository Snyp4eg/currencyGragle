package com.gmail.snyp4eg.controller;

import java.util.List;

import com.gmail.snyp4eg.model.Privatbank;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PrivatbankController implements Callback<Privatbank>{
    static final String BASE_URL = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GerritAPI gerritAPI = retrofit.create(GerritAPI.class);

        Call<Privatbank> call = gerritAPI.loadChanges("status:open");
        call.enqueue(this);

    }
    
    @Override
    public void onResponse(Call<Privatbank> call, Response<Privatbank> response) {
	if(response.isSuccessful()) {
            List<Privatbank> changesList = (List<Privatbank>) response.body();
            changesList.forEach(change -> System.out.println(change.subject));
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<Privatbank> call, Throwable t) {
	// TODO Auto-generated method stub
	
    }

}
