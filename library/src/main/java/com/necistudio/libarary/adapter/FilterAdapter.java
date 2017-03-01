package com.necistudio.libarary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.necistudio.libarary.R;

import java.util.List;

/**
 * Created by vim on 01/03/17.
 */

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterHolder>{
    private Context context;
    private List<String> itemlist;
    public FilterAdapter(Context context,List<String > itemlist){
        this.context=context;
        this.itemlist=itemlist;
    }
    @Override
    public FilterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_filter, parent, false);
        return new FilterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FilterHolder holder, int position) {
        String filter = itemlist.get(position);
        holder.txtName.setText(filter);
    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class FilterHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        public FilterHolder(View itemView) {
            super(itemView);
            txtName = (TextView)itemView.findViewById(R.id.txtName);
        }
    }
}
