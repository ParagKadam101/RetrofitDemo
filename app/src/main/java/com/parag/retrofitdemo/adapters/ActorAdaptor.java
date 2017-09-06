package com.parag.retrofitdemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.parag.retrofitdemo.R;
import com.parag.retrofitdemo.pojos.Actor;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ActorAdaptor extends RecyclerView.Adapter<ActorAdaptor.MyViewHolder> {

    private ArrayList<Actor> actorArrayList;
    public ActorAdaptor(ArrayList<Actor> actorArrayList)
    {
        this.actorArrayList = actorArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Actor actor = actorArrayList.get(position);
        holder.txtName.setText(actor.getName());
        holder.txtAge.setText(actor.getAge());
        holder.txtFilm.setText(actor.getFilm());
    }

    @Override
    public int getItemCount() {
        return actorArrayList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.txt_name) TextView txtName;
        @BindView(R.id.txt_age) TextView txtAge;
        @BindView(R.id.txt_film) TextView txtFilm;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
