package com.yupi.home.panikerapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.utils.Data;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Home on 20.8.2017..
 */

public class TopAdapter extends RecyclerView.Adapter {

    ArrayList<Data> datas;
    Context context;
    int layoutId;

    public TopAdapter(Context context, ArrayList<Data> datas, int layoutId) {
        this.context = context;
        this.datas = datas;
        this.layoutId = layoutId;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layoutId, parent, false);
        myViewHolder viewHolder = new myViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        myViewHolder viewHolder = (myViewHolder)holder;
        Data data = datas.get(position);
        viewHolder.profileImage.setImageResource(data.getProfileImage());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.profileImage)
        ImageView profileImage;
        public myViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
