package com.parag.retrofitdemo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.parag.retrofitdemo.R;
import com.parag.retrofitdemo.di.components.DaggerApplicationComponent;
import com.parag.retrofitdemo.di.modules.NetworkModule;
import com.parag.retrofitdemo.pojos.Actor;
import com.parag.retrofitdemo.util.ActorData;
import com.parag.retrofitdemo.util.UtilClass;
import java.util.ArrayList;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;

public class FormActivity extends AppCompatActivity {

    @Inject Retrofit retrofit;
    @BindView(R.id.txt_description) TextView txtDescription;
    @BindView(R.id.edt_name) EditText edtName;
    @BindView(R.id.edt_age) EditText edtAge;
    @BindView(R.id.edt_film) EditText edtFilm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);
        DaggerApplicationComponent.builder().networkModule(new NetworkModule(UtilClass.BASE_URL)).build().inject(this);
    }

    @OnClick(R.id.btn_add)
    void addActor()
    {
        String name = edtName.getText().toString().trim();
        String age = edtAge.getText().toString().trim();
        String film = edtFilm.getText().toString().trim();
        Actor actor = new Actor(name,age,film);

        UtilClass.addActor(actor, retrofit, ActorData.getActors().size());
        finish();
    }
}
