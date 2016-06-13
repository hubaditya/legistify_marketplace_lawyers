package com.example.aditya.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aditya.myapplication.activity.BankDetailsActivity;
import com.example.aditya.myapplication.activity.NotificationActivity;
import com.example.aditya.myapplication.activity.ProfileActivity;
import com.example.aditya.myapplication.activity.UserActivity;
import com.example.aditya.myapplication.activity.WalletActivity;
import com.example.aditya.myapplication.model.NavDrawerItem;
import com.example.aditya.myapplication.R;

import java.util.Collections;
import java.util.List;

public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {
    List<NavDrawerItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public NavigationDrawerAdapter(Context context, List<NavDrawerItem> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        final NavDrawerItem current = data.get(position);
        holder.title.setText(current.getTitle());
        holder.imageView.setImageResource(current.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(current.getTitle().equals("Profile"))
                {
                    Intent intent = new Intent(context, ProfileActivity.class);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }

                else if(current.getTitle().equals("Bank Details"))
                {
                    Intent intent = new Intent(context, BankDetailsActivity.class);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }

                else if(current.getTitle().equals("Wallet"))
                {
                    Intent intent = new Intent(context, WalletActivity.class);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }

                else if(current.getTitle().equals("Notifications"))
                {
                    Intent intent = new Intent(context, NotificationActivity.class);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}