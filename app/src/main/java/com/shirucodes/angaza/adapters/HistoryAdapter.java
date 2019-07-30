package com.shirucodes.angaza.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shirucodes.angaza.R;
import com.shirucodes.angaza.models.Verification;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {

    List<Verification> verificationList;
    int verificationlistSize;

    public HistoryAdapter(List<Verification> verificationList) {
        this.verificationList = verificationList;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (verificationList.size() == 0) {
            //set the list size to 1 to accomodate the default design when no recent verifications exist
            verificationlistSize = 1;
            view = inflater.inflate(R.layout.recent_search_item, parent, false);
        } else {
            verificationlistSize = verificationList.size();
            view = inflater.inflate(R.layout.recent_search_item, parent, false);

        }
        return new HistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return verificationlistSize;//total no. of items to be displayed
    }

    public class HistoryHolder extends RecyclerView.ViewHolder {
        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
