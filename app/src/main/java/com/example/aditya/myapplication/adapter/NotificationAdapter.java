package com.example.aditya.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aditya.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder>
{
    private List<String> message, date;
    private Context context;

    public NotificationAdapter(Context context, ArrayList message, ArrayList date)
    {
        this.message = message;
        this.date = date;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {
        holder.message.setText(message.get(position));
        holder.date.setText(date.get(position));
    }

    @Override
    public int getItemCount() {
        return message.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView message, date;

        public ViewHolder(View itemView)
        {
            super(itemView);

            message = (TextView) itemView.findViewById(R.id.message);
            date = (TextView) itemView.findViewById(R.id.date);
        }
    }
}


