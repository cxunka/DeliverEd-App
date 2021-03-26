package com.example.delivered;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class DHomeAdapter extends RecyclerView.Adapter<DHomeAdapter.ViewHolder>{
    private List<DHome> DHomeList;
    private Context context;

    static class ViewHolder extends RecyclerView.ViewHolder{
        Button btn_DHome;

        public ViewHolder (View view)
        {
            super(view);
            btn_DHome = (Button) view.findViewById(R.id.DHome_item);
        }

    }

    public DHomeAdapter (Context context, List <DHome> DHomeList){
        this.context = context;
        this.DHomeList = DHomeList;
    }

    @NonNull
    @Override

    public DHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_item,parent,false);
        return new DHomeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DHomeAdapter.ViewHolder holder, int position){
        DHome dHome = DHomeList.get(position);
        holder.btn_DHome.setTransitionName(dHome.getDeviceName());
        holder.btn_DHome.setText(dHome.getID());
        final AssetManager mgr = context.getAssets();
        Typeface tf = Typeface.createFromAsset(mgr, "ahronbd.ttf");
        holder.btn_DHome.setTypeface(tf);
    }

    @Override
    public int getItemCount(){
        return DHomeList.size();
    }
}
