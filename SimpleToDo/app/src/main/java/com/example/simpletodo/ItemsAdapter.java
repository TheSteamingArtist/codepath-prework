package com.example.simpletodo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder>
{

    public interface OnLongClickListener
    {
        void onItemLongClicked(int position);
    }

    public interface OnClickListener
    {
        void OnItemClicked(int position);
    }

    List<String> items;

    OnLongClickListener longClickListener;

    OnClickListener clickListener;

    public ItemsAdapter(List<String> items, OnLongClickListener longClickListener, OnClickListener clickListener)
    {
        this.items = items;

        this.longClickListener = longClickListener;

        this.clickListener = clickListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        // Use layout inflator to inflate a view
        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        // wrap it inside a view holder and return it

        return new ViewHolder(todoView);
    }

    //Responsible for binding data to a particular view holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        //Grab the item at the position
        String item = items.get(position);
        //Bind the item into the specified view holder
        holder.bind(item);

    }
    //Tells Recycler View how many items are in the list
    @Override
    public int getItemCount() {
        return items.size();
    }
    // Container to provide easy access to views that represent each row of the list

    class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView tvItem;

        public ViewHolder(@NonNull View itemView)
        {

            super(itemView);

            tvItem = itemView.findViewById(android.R.id.text1);
        }

        //Update the view inside of the view holder with data of string item
        public void bind(String item)
        {
            tvItem.setText(item);
            tvItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.OnItemClicked(getBindingAdapterPosition());
                }
            });
            tvItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view)
                {
                    //notify the listener, which position was long pressed
                    longClickListener.onItemLongClicked(getBindingAdapterPosition());
                    return true;
                }
            });
        }
    }
}
