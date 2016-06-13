package com.example.aditya.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.aditya.myapplication.R;
import com.example.aditya.myapplication.adapter.NotificationAdapter;
import com.example.aditya.myapplication.adapter.WalletAdapter;
import com.example.aditya.myapplication.view.VerticalSpaceItemDecoration;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity
{
    private ImageView notification_back;
    private Toolbar toolbar;

    private static final int VERTICAL_ITEM_SPACE = 32;

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;

    private ArrayList<String> message, date;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        toolbar = (Toolbar) findViewById(R.id.toolbar8);
        setSupportActionBar(toolbar);

        notification_back = (ImageView) findViewById(R.id.notification_back);

        notification_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(NotificationActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE));

        message = new ArrayList<>();
        date = new ArrayList<>();

        message.add("Your bid has been accepted");
        message.add("Your account has been credited with INR 1000");
        message.add("Query posted");
        message.add("Your bid has been rejected");
        date.add("27/05/16");
        date.add("23/05/16");
        date.add("18/05/16");
        date.add("16/05/16");

        mAdapter = new NotificationAdapter(this, message, date);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(NotificationActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
