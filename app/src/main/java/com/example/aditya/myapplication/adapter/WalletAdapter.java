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

public class WalletAdapter extends RecyclerView.Adapter<WalletAdapter.ViewHolder>
{
    private List<String> userName;
    private List<String> tag;
    private List<String> statement;
    private List<String> amountDue;
    private List<String> payable;
    private List<String> paymentDate;
    private Context context;

    public WalletAdapter(Context context, ArrayList userName, ArrayList tag, ArrayList statement, ArrayList amountDue,
                              ArrayList payable, ArrayList<String> paymentDate)
    {
        this.userName = userName;
        this.tag = tag;
        this.statement = statement;
        this.amountDue = amountDue;
        this.payable = payable;
        this.context = context;
        this.paymentDate = paymentDate;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wallet_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {
        holder.payeeText.setText(userName.get(position));
        holder.serviceText.setText(tag.get(position));
        holder.statementText.setText(statement.get(position));
        holder.payableText.setText(payable.get(position));
        holder.dateText.setText(paymentDate.get(position));

        if(amountDue.get(position).equals("0"))
        {
            holder.amountText.setText("Amount Paid");
            holder.amountText.setTextColor(Color.parseColor("#4CAF50"));
        }

        else holder.amountText.setText(amountDue.get(position));
    }

    @Override
    public int getItemCount() {
        return userName.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView payeeText, serviceText, statementText, amountText, payableText, dateText;

        public ViewHolder(View itemView)
        {
            super(itemView);

            payeeText = (TextView) itemView.findViewById(R.id.payeeText);
            serviceText = (TextView) itemView.findViewById(R.id.serviceText);
            statementText = (TextView) itemView.findViewById(R.id.statementText);
            amountText = (TextView) itemView.findViewById(R.id.amountText);
            payableText = (TextView) itemView.findViewById(R.id.totalPayableText);
            dateText = (TextView) itemView.findViewById(R.id.dateText);
        }
    }
}

