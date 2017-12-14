package com.mireagaloideal.apportame.main.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mireagaloideal.apportame.R;
import com.mireagaloideal.apportame.data.RegaloFromWS;
import com.mireagaloideal.apportame.interfaces.OnItemClickListener;

import java.util.List;

/**
 * Created by Jordán Rosas on 13/12/2017.
 */

public class RecyclerSearchGiftsAdapter extends RecyclerView.Adapter<RecyclerViewSearchGiftsHolder> {

    private List<RegaloFromWS> itemList;
    private OnItemClickListener listener;

    public RecyclerSearchGiftsAdapter(List<RegaloFromWS> list, OnItemClickListener onItemClickListener) {
        itemList = list;
        listener = onItemClickListener;
    }

    @Override
    public RecyclerViewSearchGiftsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_result_gifts, parent, false);
        RecyclerViewSearchGiftsHolder recyclerViewPetsHolders = new RecyclerViewSearchGiftsHolder(view);
        return recyclerViewPetsHolders;
    }

    @Override
    public void onBindViewHolder(RecyclerViewSearchGiftsHolder holder, int position) {
        RegaloFromWS regalo = itemList.get(position);
        holder.bind(regalo, listener);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
