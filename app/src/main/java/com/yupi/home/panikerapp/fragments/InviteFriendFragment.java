package com.yupi.home.panikerapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class InviteFriendFragment extends Fragment {

    @BindView(R.id.listView)
    ListView listView;
    ArrayList<String> integers;
    ArrayAdapter<String> adapter;
    @BindView(R.id.topic)
    TextView topic;
    public InviteFriendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_invite_friend, container, false);
        ButterKnife.bind(this, view);
        integers = new ArrayList<>();
        integers.add("John Doe");
        integers.add("John Doe");
        integers.add("John Doe");
        integers.add("John Doe");
        adapter = new ArrayAdapter<String>(getActivity(), R.layout.invite_friends_adapter_layout, R.id.name, integers);
        listView.setAdapter(adapter);
        topic.setText("Invite friends");
        return view;
    }
    @OnClick({R.id.returnBack})
    public void returnBack(View view){
        switch (view.getId()){
            case R.id.returnBack:
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.remove(InviteFriendFragment.this).commit();
                break;
        }
    }
}
