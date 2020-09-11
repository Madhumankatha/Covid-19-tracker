package com.madhumankatha.covid19tracker;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Covid> summaryList;

    public Adapter(ArrayList<Covid> summaryList) {
        this.summaryList = summaryList;
        Log.d("TAG", "Adapter: " + summaryList.get(0).getCountryName());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_holder,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvCountryName.setText(summaryList.get(position).getCountryName());
        holder.tvTotalCases.setText("" + summaryList.get(position).getTotalCases());
        holder.tvNewCases.setText("" + summaryList.get(position).getNewCases());
    }

    @Override
    public int getItemCount() {
        return summaryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCountryName,tvTotalCases,tvNewCases;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCountryName = itemView.findViewById(R.id.tvCountry);
            tvTotalCases = itemView.findViewById(R.id.tvTotalCases);
            tvNewCases = itemView.findViewById(R.id.tvNewCases);
        }
    }
}
