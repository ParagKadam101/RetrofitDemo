package com.parag.retrofitdemo.di.modules;


import com.parag.retrofitdemo.di.scope.ApplicationComponentScope;
import com.parag.retrofitdemo.pojos.Actor;

import java.util.ArrayList;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class NetworkModule {

    private String baseurl;
    public NetworkModule(String baseUrl)
    {
        this.baseurl = baseUrl;
    }

    @Provides @ApplicationComponentScope
    public Retrofit retrofit()
    {
        return new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
    }
}
