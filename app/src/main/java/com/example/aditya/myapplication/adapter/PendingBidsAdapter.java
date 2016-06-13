package com.example.aditya.myapplication.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aditya.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class PendingBidsAdapter extends RecyclerView.Adapter<PendingBidsAdapter.ViewHolder>
{
    private List<String> dir;
    private List<String> capital;
    private List<String> amount;
    private List<String> place;
    private List<String> service;
    private List<String> status;
    private List<String> bid;
    private Context context;

    public PendingBidsAdapter(Context context, ArrayList dir, ArrayList capital, ArrayList amount, ArrayList service,
                              ArrayList place, ArrayList<String> status, ArrayList<String> bid)
    {
        this.dir = dir;
        this.capital = capital;
        this.amount = amount;
        this.place = place;
        this.service = service;
        this.context = context;
        this.status = status;
        this.bid = bid;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pending_bids_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {
        holder.tv20.setText(service.get(position));
        holder.tv21.setText(dir.get(position));
        holder.tv22.setText(capital.get(position));
        holder.tv31.setText(amount.get(position));
        holder.tv23.setText(place.get(position));
        holder.tv.setText(status.get(position));
        holder.tamount.setText(bid.get(position));

        if(status.get(position).equals("Rejected"))
            holder.tv.setTextColor(Color.parseColor("#F44336"));

        Bitmap icon = BitmapFactory.decodeResource(context.getResources(),R.drawable.red);
        holder.imageView2.setImageBitmap(icon);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if(holder.tv14.getVisibility() == View.GONE)
                {
                    holder.tv14.setVisibility(View.VISIBLE);
                }

                else
                {
                    holder.tv14.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dir.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv, tv12, tv14, tv20, tv21, tv22, tv23, tv31, tamount;
        ImageView imageView2;

        public ViewHolder(View itemView)
        {
            super(itemView);

            tamount = (TextView) itemView.findViewById(R.id.amount);
            tv = (TextView) itemView.findViewById(R.id.tv);
            tv12 = (TextView) itemView.findViewById(R.id.textView12);
            tv14 = (TextView) itemView.findViewById(R.id.textView14);
            tv20 = (TextView) itemView.findViewById(R.id.textView20);
            tv21 = (TextView) itemView.findViewById(R.id.textView21);
            tv22 = (TextView) itemView.findViewById(R.id.textView22);
            tv23 = (TextView) itemView.findViewById(R.id.textView23);
            tv31 = (TextView) itemView.findViewById(R.id.textView31);
            imageView2 = (ImageView) itemView.findViewById(R.id.imageView2);

        }
    }
}
