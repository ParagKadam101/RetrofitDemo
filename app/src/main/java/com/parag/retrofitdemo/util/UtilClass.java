package com.parag.retrofitdemo.util;


import com.parag.retrofitdemo.Events.ResponseEvent;
import com.parag.retrofitdemo.pojos.Actor;
import com.parag.retrofitdemo.retrofit.RetrofitApi;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UtilClass {
    public static final String BASE_URL = "https://sampleapp-f4f6a.firebaseio.com/";

    public static void getActors(Retrofit retrofit)
    {
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Call<List<Actor>> actorArrayList = retrofitApi.getActors();
        actorArrayList.enqueue(new Callback<List<Actor>>() {
            @Override
            public void onResponse(Call<List<Actor>> call, Response<List<Actor>> response) {
                EventBus.getDefault().post(new ResponseEvent(response));
            }

            @Override
            public void onFailure(Call<List<Actor>> call, Throwable t) {}
        });
    }

    public static void addActor(Actor actor,Retrofit retrofit, int size)
    {
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Call<Actor> actorResponse= retrofitApi.addActor(size,actor);
        actorResponse.enqueue(new Callback<Actor>() {
            @Override
            public void onResponse(Call<Actor> call, Response<Actor> response) {
                if(response.code() == 200) {
                    EventBus.getDefault().postSticky("200");
                }
            }

            @Override
            public void onFailure(Call<Actor> call, Throwable t) {}
        });
    }
}
