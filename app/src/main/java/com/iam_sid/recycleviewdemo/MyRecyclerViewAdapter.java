package com.iam_sid.recycleviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>  {

    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public MyRecyclerViewAdapter(Context context,List<String> mData) {
        this.mData = mData;
        this.mInflater = mInflater.from(context);
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= mInflater.inflate(R.layout.recycleview_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int position) {
        String version =mData.get(position);
        holder.myHolderView.setText(version);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    void setmClickListener(ItemClickListener itemClickListener){
    this.mClickListener=itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView myHolderView;
        public ViewHolder(View itemView) {
            super(itemView);
            myHolderView = itemView.findViewById(R.id.tvItems);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mClickListener != null) mClickListener.onItemClicked(v, getAdapterPosition());
        }
    }

    public interface ItemClickListener{
        void onItemClicked(View view,int position);
    }
}

