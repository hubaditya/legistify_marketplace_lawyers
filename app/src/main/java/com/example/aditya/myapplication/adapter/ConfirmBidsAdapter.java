package com.example.aditya.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aditya.myapplication.R;
import com.example.aditya.myapplication.activity.UserActivity;

import java.util.ArrayList;
import java.util.List;

public class ConfirmBidsAdapter extends RecyclerView.Adapter<ConfirmBidsAdapter.ViewHolder>
{
    private List<String> dir;
    private List<String> capital;
    private List<String> amount;
    private List<String> location;
    private List<String> timeline;
    private Context context;

    public ConfirmBidsAdapter(Context context, ArrayList dir, ArrayList capital, ArrayList amount,
                              ArrayList location, ArrayList timeline)
    {
        this.context = context;
        this.dir = dir;
        this.capital = capital;
        this.amount = amount;
        this.location = location;
        this.timeline = timeline;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.confirm_bids_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(context, view);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(),R.drawable.green);
        holder.imageView2.setImageBitmap(icon);

        Bitmap icon2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.image);
        holder.imageView3.setImageBitmap(icon2);
    }

    @Override
    public int getItemCount() {
        return dir.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        Context context;
        ImageView imageView2, imageView3;

        public ViewHolder(final Context context, View itemView)
        {
            super(itemView);
            this.context = context;

            imageView2 = (ImageView) itemView.findViewById(R.id.imageView2);
            imageView3 = (ImageView) itemView.findViewById(R.id.imageView3);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, UserActivity.class);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }
            });

        }
    }
}
