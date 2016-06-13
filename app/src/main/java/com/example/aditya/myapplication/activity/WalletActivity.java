package com.example.aditya.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.aditya.myapplication.R;
import com.example.aditya.myapplication.adapter.WalletAdapter;

import java.util.ArrayList;

public class WalletActivity extends AppCompatActivity
{
    private Toolbar toolbar;
    private ImageView wallet_back;

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;

    private ArrayList<String> userName, tag, statement, amountDue, payable, paymentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        toolbar = (Toolbar) findViewById(R.id.toolbar10);
        setSupportActionBar(toolbar);

        wallet_back = (ImageView) findViewById(R.id.wallet_back);

        wallet_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(WalletActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        userName = new ArrayList<>();
        tag = new ArrayList<>();
        amountDue = new ArrayList<>();
        paymentDate = new ArrayList<>();
        payable = new ArrayList<>();
        statement = new ArrayList<>();

        userName.add("Aditya Srivastava");
        userName.add("Avinash Singh");
        tag.add("TradeMark");
        tag.add("Incorporation");
        amountDue.add("INR 200");
        amountDue.add("0");
        paymentDate.add("15/05/16");
        paymentDate.add("20/05/16");
        payable.add("INR 500");
        payable.add("INR 1000");
        statement.add("INR 300");
        statement.add("INR 1000");

        mAdapter = new WalletAdapter(this, userName, tag, statement, amountDue, payable, paymentDate);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(WalletActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
