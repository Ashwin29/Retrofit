package com.winision.sampleapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private List<Modal> data;
    private Context context;

    public static class DataViewHolder extends RecyclerView.ViewHolder {

        TextView userId;
        TextView titleTxt;
        TextView details;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userIdTxt);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            details = itemView.findViewById(R.id.detailsTxt);
        }
    }

    public DataAdapter(List<Modal> data, int cardholder, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public DataAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardholder,  viewGroup, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.DataViewHolder dataViewHolder, int i) {
        dataViewHolder.userId.setText(data.get(i).getUserId());
        dataViewHolder.titleTxt.setText(data.get(i).getTitle());
        dataViewHolder.details.setText(data.get(i).getBody());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
