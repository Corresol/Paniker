package com.yupi.home.panikerapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.utils.Data;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Home on 16.8.2017..
 */

public class MainAdapterFeed extends RecyclerView.Adapter {

    private ArrayList<Data> datas;
    private Context context;
    private ClickListeners clickListeners;

    public MainAdapterFeed(Context context, ArrayList<Data> numbers, ClickListeners clickListeners) {
        this.context = context;
        this.datas = numbers;
        this.clickListeners = clickListeners;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_adapter_layout, parent, false);
        myViewHolder viewHolder = new myViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Data data = datas.get(position);
        myViewHolder viewHolder = (myViewHolder)holder;
        viewHolder.profileImage.setImageResource(data.getProfileImage());
        viewHolder.mainImage.setImageResource(data.getMainImagePost());
        viewHolder.profileName.setText(data.getProfileName());
        viewHolder.text.setText(data.getMainTextPost());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.profileImage)
        ImageView profileImage;
        @BindView(R.id.profileName)
        TextView profileName;
        @BindView(R.id.mainImagePost)
        ImageView mainImage;
        @BindView(R.id.mainTextPost)
        TextView text;
        private myViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
            profileImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
                clickListeners.profileImageClickListener(v, getAdapterPosition());
        }
    }
    public interface ClickListeners{
        void profileImageClickListener(View view, int position);
    }
}
