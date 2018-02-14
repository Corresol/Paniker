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
public class BlockedUsersFragment extends Fragment {

    @BindView(R.id.listView)
    ListView listView;
    ArrayList<String> integers;
    ArrayAdapter<String> adapter;
    @BindView(R.id.topic)
    TextView topic;
    public BlockedUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) { // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_blocked_users, container, false);
        ButterKnife.bind(this, view);
    integers = new ArrayList<>();
        integers.add("John Doe");
        integers.add("John Doe");
        integers.add("John Doe");
        integers.add("John Doe");
    adapter = new ArrayAdapter<String>(getActivity(), R.layout.blocked_users_adapter, R.id.name, integers);
        listView.setAdapter(adapter);
        topic.setText("Blocked Users");
        return view;
}
    @OnClick({R.id.returnBack})
    public void returnBack(View view){
        switch (view.getId()){
            case R.id.returnBack:
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.remove(BlockedUsersFragment.this).commit();
                break;
        }
    }

}
