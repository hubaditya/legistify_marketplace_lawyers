package com.example.aditya.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.aditya.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ServiceAdapter extends BaseAdapter implements Filterable
{
    private List<String> service, mStringFilterList;
    private Context context;
    private LayoutInflater inflater;
    private ValueFilter valueFilter;

    public ServiceAdapter(Context context, ArrayList service)
    {
        this.context = context;
        this.service = service;
        this.mStringFilterList = service;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        getFilter();
    }

    @Override
    public int getCount() {
        return service.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final ViewHolderItem viewHolder;

        if(convertView==null){

            inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.service_list_row, parent, false);

            viewHolder = new ViewHolderItem();
            viewHolder.serviceText = (TextView) convertView.findViewById(R.id.serviceText);

            convertView.setTag(viewHolder);
        }

        else viewHolder = (ViewHolderItem) convertView.getTag();

        viewHolder.serviceText.setText(service.get(position));

        /*viewHolder.unchecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.unchecked.setVisibility(View.GONE);
                viewHolder.checked.setVisibility(View.VISIBLE);
            }
        });

        viewHolder.checked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.checked.setVisibility(View.GONE);
                viewHolder.unchecked.setVisibility(View.VISIBLE);
            }
        });*/

        viewHolder.serviceText.setTag(position);
        //viewHolder.checked.setTag(position);
        //viewHolder.unchecked.setTag(position);

        return convertView;
    }

    @Override
    public Filter getFilter()
    {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    static class ViewHolderItem {
        TextView serviceText;
    }

    private class ValueFilter extends Filter
    {
        @Override
        protected FilterResults performFiltering(CharSequence constraint)
        {
            FilterResults results=new FilterResults();

            if(constraint!=null && constraint.length()>0)
            {
                ArrayList<String> filterList=new ArrayList();

                for(int i=0;i<mStringFilterList.size();i++)
                {
                    if((mStringFilterList.get(i).toUpperCase())
                            .contains(constraint.toString().toUpperCase()))
                    {
                        filterList.add(mStringFilterList.get(i));
                    }
                }
                results.count=filterList.size();
                results.values=filterList;
            }

            else
            {
                results.count=mStringFilterList.size();
                results.values=mStringFilterList;
            }
            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results)
        {
            service = (ArrayList<String>) results.values;
            notifyDataSetChanged();
        }
    }

}



