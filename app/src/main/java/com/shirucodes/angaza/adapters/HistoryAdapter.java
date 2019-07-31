package com.shirucodes.angaza.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shirucodes.angaza.R;
import com.shirucodes.angaza.models.Verification;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {

    private ArrayList<Verification> verificationList;
    private int itemcount = 0; // yet to implement

    public HistoryAdapter(ArrayList<Verification> verificationList) {
        this.verificationList = verificationList;

    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (itemcount == verificationList.size()) {
            itemcount = 1;
            view = inflater.inflate(R.layout.recent_search_item, parent, false);
        } else {
            view = inflater.inflate(R.layout.recent_search_item, parent, false);
        }

        return new HistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return verificationList.size();//itemcount total no. of items to be displayed
    }

    public class HistoryHolder extends RecyclerView.ViewHolder {
        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
