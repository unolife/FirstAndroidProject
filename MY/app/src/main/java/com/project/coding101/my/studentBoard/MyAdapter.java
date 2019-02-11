package com.project.coding101.my.studentBoard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.coding101.my.R;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder>{

    private ArrayList<recycler_item> mList;

    public MyAdapter(ArrayList<recycler_item> list){
        this.mList = list;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_item,viewGroup,false);


        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder viewHolder, int i) {
        viewHolder.mTitle.setText(mList.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView mTitle;

        public ItemViewHolder(View view){
            super(view);
            this.mTitle = (TextView)view.findViewById(R.id.itemTitle);
        }
    }
}

