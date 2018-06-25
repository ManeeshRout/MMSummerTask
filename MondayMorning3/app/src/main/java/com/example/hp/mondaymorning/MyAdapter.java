package com.example.hp.mondaymorning;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
     private List<ListItem> listItems;
     private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cards,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem listItem=listItems.get(position);
        holder.textViewTitle.setText(listItem.getTitle());
        holder.textViewEditors.setText(listItem.getEditors());
        holder.textViewViewers.setText(listItem.getViews());
        holder.textViewDate.setText(listItem.getDate());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView  textViewTitle;
        public TextView  textViewEditors;

        public TextView textViewViewers;
        public TextView textViewDate;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewTitle= (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewEditors= (TextView) itemView.findViewById(R.id.textViewEditors);
            textViewViewers= (TextView) itemView.findViewById(R.id.textViewViewers);
            textViewDate= (TextView) itemView.findViewById(R.id.textViewDate);

        }
    }
}
