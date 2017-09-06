package com.parag.retrofitdemo.util;

import com.parag.retrofitdemo.pojos.Actor;

import java.util.ArrayList;

public class ActorData {
    private static final ArrayList<Actor> actors = new ArrayList<>();
    private ActorData(){}
    public static ArrayList<Actor> getActors()
    {
        return actors;
    }
}
