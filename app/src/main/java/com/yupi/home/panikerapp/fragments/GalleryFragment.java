package com.yupi.home.panikerapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.adapter.GalleryAdapter;
import com.yupi.home.panikerapp.utils.Constants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    GalleryAdapter galleryAdapter;
    ArrayList<Integer> integers;

    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.images_gallery_adapter_layout,
                container, false);
        ButterKnife.bind(this, view);
        setupAdapter();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.multi_media_menu, menu);
    }


    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.forward).setVisible(false);
    }

    @Override
    public void onResume() {
        super.onResume();
        //  getActivity().invalidateOptionsMenu();
    }

    private void setupAdapter() {
        integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(5);
        integers.add(1);
        integers.add(3);
        integers.add(5);
        integers.add(1);
        integers.add(3);
        integers.add(5);
        integers.add(1);
        integers.add(3);
        integers.add(5);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerView.hasFixedSize();
        galleryAdapter = new GalleryAdapter(getActivity(), integers, new GalleryAdapter.ImageClicks() {
            @Override
            public void markImage(View view, ImageView imageView, int position) {
                Log.d("DebuggingClick", "");
                imageView.setVisibility(View.VISIBLE);
            }
        });

        recyclerView.setAdapter(galleryAdapter);
    }

    @OnClick({R.id.galleryImages})
    public void openEditImageFragment(View view) {
        switch (view.getId()) {
            case R.id.galleryImages:
                transaction(R.id.rootLayout, new EditImagesFragment()).commit();
                break;
        }
    }

    private FragmentTransaction transaction(int id, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(id, fragment);
        return fragmentTransaction;
    }
}
