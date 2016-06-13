package com.example.aditya.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aditya.myapplication.R;
import com.example.aditya.myapplication.activity.BidDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.ViewHolder> {
    private List<String> dir, capital, amount, service, place, status;
    private Context context;

    public JobsAdapter(Context context, ArrayList dir, ArrayList capital, ArrayList amount, ArrayList service,
                       ArrayList place, ArrayList status) {
        this.dir = dir;
        this.capital = capital;
        this.amount = amount;
        this.service = service;
        this.context = context;
        this.place = place;
        this.status = status;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jobs_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tv20.setText(service.get(position));
        holder.tv21.setText(dir.get(position));
        holder.tv22.setText(capital.get(position));
        holder.tv31.setText(amount.get(position));
        holder.tv23.setText(place.get(position));

        holder.tv.setText(status.get(position));
        if (status.get(position).equals("Closed"))
            holder.tv.setTextColor(Color.parseColor("#F44336"));

        Bitmap icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.image);
        holder.imageView1.setImageBitmap(icon);

        holder.button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(context, BidDetailsActivity.class);
                context.startActivity(intent);
                ((Activity) context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dir.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv, tv20, tv21, tv22, tv23, tv31;
        Button button;
        ImageView imageView1;

        public ViewHolder(View itemView, final Context context) {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.tv);
            tv20 = (TextView) itemView.findViewById(R.id.textView20);
            tv21 = (TextView) itemView.findViewById(R.id.textView21);
            tv22 = (TextView) itemView.findViewById(R.id.textView22);
            tv23 = (TextView) itemView.findViewById(R.id.textView23);
            tv31 = (TextView) itemView.findViewById(R.id.textView31);
            button = (Button) itemView.findViewById(R.id.button);
            imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, BidDetailsActivity.class);
                    if (context instanceof Callback) {
                        ((Callback) context).startActivity();
                    }
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }
            });
        }
    }

    public interface Callback {
        void startActivity();
    }
}
