package com.example.aditya.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aditya.myapplication.adapter.PendingBidsAdapter;
import com.example.aditya.myapplication.R;

import java.util.ArrayList;

public class BidsFragment extends Fragment
{
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;

    private ArrayList<String> dir, capital, amount;
    private ArrayList<String> place, service, status, bid;

    public BidsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this bids_fragment
        return inflater.inflate(R.layout.bids_fragment, container, false);
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
        place = new ArrayList<>();
        service = new ArrayList<>();
        status = new ArrayList<>();
        bid = new ArrayList<>();

        dir.add("2");
        dir.add("3");
        amount.add("1000");
        amount.add("2000");
        capital.add("3000");
        capital.add("4000");
        service.add("Register Private Limited Company");
        service.add("Trademark needed");
        place.add("Delhi");
        place.add("Lucknow");
        status.add("Pending");
        status.add("Rejected");
        bid.add("2500");
        bid.add("3000");

        mAdapter = new PendingBidsAdapter(rootView.getContext(), dir, capital, amount, service, place, status, bid);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

}
