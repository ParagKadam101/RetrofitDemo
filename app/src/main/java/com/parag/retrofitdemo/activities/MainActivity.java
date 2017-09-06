package com.parag.retrofitdemo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.parag.retrofitdemo.R;
import com.parag.retrofitdemo.Events.ResponseEvent;
import com.parag.retrofitdemo.adapters.ActorAdaptor;
import com.parag.retrofitdemo.di.components.DaggerApplicationComponent;
import com.parag.retrofitdemo.di.modules.NetworkModule;
import com.parag.retrofitdemo.pojos.Actor;
import com.parag.retrofitdemo.util.ActorData;
import com.parag.retrofitdemo.util.UtilClass;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.ArrayList;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    @Inject Retrofit retrofit;
    @BindView(R.id.recyclerview) RecyclerView recyclerView;
    @BindView(R.id.progress_bar) ProgressBar progressBar;
    ActorAdaptor actorAdaptor;
    ArrayList<Actor> actors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerApplicationComponent.builder().networkModule(new NetworkModule(UtilClass.BASE_URL)).build().inject(this);
        UtilClass.getActors(retrofit);
        progressBar.setVisibility(View.VISIBLE);
        actors = ActorData.getActors();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode =  ThreadMode.MAIN)
    public void setRecyclerView(ResponseEvent responseEvent)
    {
        progressBar.setVisibility(View.INVISIBLE);
        actors.clear();
        actors.addAll(responseEvent.response.body());
        actorAdaptor = new ActorAdaptor(actors);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(actorAdaptor);
    }

    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void recyclerViewChanged(String responseCode)
    {
        Toast.makeText(this,"Actor added",Toast.LENGTH_SHORT).show();
        UtilClass.getActors(retrofit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                startActivity(new Intent(this,FormActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
