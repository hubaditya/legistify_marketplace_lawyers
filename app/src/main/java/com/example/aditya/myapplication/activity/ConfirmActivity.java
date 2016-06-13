package com.example.aditya.myapplication.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.aditya.myapplication.fragment.ConfirmFragment;

public class ConfirmActivity extends FragmentActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, new ConfirmFragment()).commit();}
    }
}