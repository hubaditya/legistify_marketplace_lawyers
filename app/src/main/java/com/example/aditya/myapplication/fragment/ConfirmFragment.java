package com.example.aditya.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aditya.myapplication.R;
import com.example.aditya.myapplication.adapter.ConfirmBidsAdapter;

import java.util.ArrayList;

public class ConfirmFragment extends Fragment
{
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;

    private ArrayList<String> dir, capital, amount, location, timeline;

    public ConfirmFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this bids_fragment
        return inflater.inflate(R.layout.confirm_fragment, container, false);
    }

    @Override
    public void onViewCreated(View rootView, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(rootView, savedInstanceState);

        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        dir = new ArrayList<>();
        capital = new ArrayList<>();
        amount = new ArrayList<>();
        timeline = new ArrayList<>();
        location = new ArrayList<>();

        dir.add("2");
        dir.add("3");
        amount.add("1000");
        amount.add("2000");
        capital.add("3000");
        capital.add("4000");
        location.add("Delhi");
        location.add("Lucknow");
        timeline.add("1 week");
        timeline.add("2 weeks");

        mAdapter = new ConfirmBidsAdapter(rootView.getContext(), dir, capital, amount, location, timeline);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }


}
