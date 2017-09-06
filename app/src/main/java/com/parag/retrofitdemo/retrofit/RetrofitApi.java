package com.parag.retrofitdemo.retrofit;

import com.parag.retrofitdemo.pojos.Actor;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitApi {

    @GET("actors.json")
    Call<List<Actor>> getActors();

    @PATCH("actors/{id}/.json")
    Call<Actor> addActor(@Path("id") int id, @Body Actor actor);

}
