package com.parag.retrofitdemo.di.components;

import com.parag.retrofitdemo.activities.FormActivity;
import com.parag.retrofitdemo.activities.MainActivity;
import com.parag.retrofitdemo.di.modules.NetworkModule;
import com.parag.retrofitdemo.di.scope.ApplicationComponentScope;
import dagger.Component;


@ApplicationComponentScope
@Component(modules = {NetworkModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
    void inject(FormActivity formActivity);
}
