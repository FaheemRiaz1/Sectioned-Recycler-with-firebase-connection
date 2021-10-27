package com.example.sectionedrecylerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChildRecyclerAdapter extends RecyclerView.Adapter<ChildRecyclerAdapter.ViewHolder> {

    List<String> items;
    List<Integer> images;
    List<Integer> images1;
    List<String> items1;

    public ChildRecyclerAdapter(List<String> items,List<String> items1,List<Integer> images,List<Integer> images1) {
        this.items = items;
        this.images=images;
        this.items1=items1;
        this.images1=images1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemTextView.setText(items.get(position));
        holder.itemTextView1.setText(items1.get(position));
        holder.itemImageView.setImageResource(images.get(position));
        holder.itemImageView1.setImageResource(images1.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemTextView;
        TextView itemTextView1;
        ImageView itemImageView;
        ImageView itemImageView1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemTextView = itemView.findViewById(R.id.itemTextView);
            itemTextView1 = itemView.findViewById(R.id.itemTextView1);
            itemImageView = itemView.findViewById(R.id.itemImageView);
            itemImageView1 = itemView.findViewById(R.id.itemImageView1);

        }
    }
}