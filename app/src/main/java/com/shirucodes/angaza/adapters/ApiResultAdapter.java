package com.shirucodes.angaza.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shirucodes.angaza.R;
import com.shirucodes.angaza.models.Paragraph;


import java.util.ArrayList;

public class ApiResultAdapter extends RecyclerView.Adapter<ApiResultAdapter.ApiResultHolder> {

    private ArrayList<Paragraph> paragraphArrayList;
    private int paragraphCount = 0;

    public ApiResultAdapter(ArrayList<Paragraph> paragraphArrayList) {
        this.paragraphArrayList = paragraphArrayList;
    }

    @NonNull
    @Override
    public ApiResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recent_search_item, parent, false);
        return new ApiResultHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApiResultHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return paragraphArrayList.size(); //gives the total number of paragraphs to be relayed on the result screen
    }

    public class ApiResultHolder extends RecyclerView.ViewHolder {
        public ApiResultHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
