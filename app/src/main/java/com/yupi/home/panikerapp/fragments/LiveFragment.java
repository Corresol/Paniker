package com.yupi.home.panikerapp.fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveFragment extends Fragment {

    @BindView(R.id.commentsLayout)
    LinearLayout commentsLayout;
    @BindView(R.id.docsLayout)
    LinearLayout docsLayout;
    @BindView(R.id.comments)
    ImageView comments;
    @BindView(R.id.documents)
    ImageView documents;
    public LiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.panic_layout, container, false);
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ButterKnife.bind(this, view);
        return view;
    }
    @OnClick({R.id.comments, R.id.documents, R.id.closeComments, R.id.endLive, R.id.closeDocuments})
    public void setClicks(View view){
        switch (view.getId()){
            case R.id.comments:
                if (docsLayout.getVisibility() == View.VISIBLE)
                    docsLayout.setVisibility(View.GONE);
                if (documents.getVisibility() == View.INVISIBLE)
                    documents.setVisibility(View.VISIBLE);
                commentsLayout.setVisibility(View.VISIBLE);
                comments.setVisibility(View.INVISIBLE);
                break;
            case R.id.documents:
                if (commentsLayout.getVisibility() == View.VISIBLE)
                    commentsLayout.setVisibility(View.GONE);
                if (comments.getVisibility() == View.INVISIBLE)
                    comments.setVisibility(View.VISIBLE);
                docsLayout.setVisibility(View.VISIBLE);
                documents.setVisibility(View.INVISIBLE);
                break;
            case R.id.closeComments:
                commentsLayout.setVisibility(View.GONE);
                comments.setVisibility(View.VISIBLE);
                break;
            case R.id.closeDocuments:
                docsLayout.setVisibility(View.GONE);
                documents.setVisibility(View.VISIBLE);
                break;
            case R.id.endLive:
                removeFragment(LiveFragment.this).commit();
                clearFlags();
                break;
        }
    }
    private AlertDialog.Builder builder(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_select_file_layout, null);
        builder.setView(view);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return builder;
    }
    private FragmentTransaction removeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        return fragmentTransaction;
    }
    private void clearFlags(){
        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
