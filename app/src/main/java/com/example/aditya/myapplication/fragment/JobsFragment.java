package com.example.aditya.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aditya.myapplication.R;
import com.example.aditya.myapplication.adapter.JobsAdapter;

import java.util.ArrayList;

public class JobsFragment extends Fragment
{
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;

    private ArrayList<String> service, dir, capital, amount, place, status;

    public JobsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this bids_fragment
        return inflater.inflate(R.layout.jobs_fragment, container, false);
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
        service = new ArrayList<>();
        place = new ArrayList<>();
        status = new ArrayList<>();

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
        status.add("Active");
        status.add("Closed");

        mAdapter = new JobsAdapter(rootView.getContext(), dir, capital, amount, service, place, status);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }


}
