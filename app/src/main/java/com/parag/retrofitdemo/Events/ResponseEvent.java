package com.parag.retrofitdemo.Events;

import com.parag.retrofitdemo.pojos.Actor;
import java.util.List;
import retrofit2.Response;

public class ResponseEvent {
    public Response<List<Actor>> response;

    public ResponseEvent(Response<List<Actor>> response) {
        this.response = response;
    }
}
