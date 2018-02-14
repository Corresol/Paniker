package com.yupi.home.panikerapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yupi.home.panikerapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Home on 17.8.2017..
 */

public class GalleryAdapter extends RecyclerView.Adapter {

    ArrayList<Integer> numbers;
    Context context;
    ImageClicks imageClicks;

    public GalleryAdapter(Context context, ArrayList<Integer> numbers, ImageClicks imageClicks) {
        this.context = context;
        this.numbers = numbers;
        this.imageClicks = imageClicks;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_first_gallery_layout, parent, false);
        myViewHolder viewHolder = new myViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.selectImage)
        ImageView selectImage;
        @BindView(R.id.firstImage)
        ImageView firstImage;

        private myViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
          firstImage.setTag(getAdapterPosition());
          firstImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(selectImage.getVisibility() == View.INVISIBLE)
                    selectImage.setVisibility(View.VISIBLE);
                    else
                        selectImage.setVisibility(View.INVISIBLE);
                }
            });
        }

        @Override
        public void onClick(View v) {
            imageClicks.markImage(v, firstImage, getAdapterPosition());
        }
    }
    public interface ImageClicks{
        void markImage(View view, ImageView imageView, int position);
    }
}
