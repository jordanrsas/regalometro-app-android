package com.mireagaloideal.apportame.main.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mireagaloideal.apportame.App;
import com.mireagaloideal.apportame.R;
import com.mireagaloideal.apportame.data.RegaloFromWS;
import com.mireagaloideal.apportame.interfaces.OnItemClickListener;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Jordán Rosas on 13/12/2017.
 */

public class RecyclerViewSearchGiftsHolder extends RecyclerView.ViewHolder {

    public ImageView itemImage;
    public TextView price;
    public TextView itemName;

    public RecyclerViewSearchGiftsHolder(View itemView) {
        super(itemView);
        itemImage = itemView.findViewById(R.id.itemImage);
        price = itemView.findViewById(R.id.itemPrice);
        itemName = itemView.findViewById(R.id.itemName);

    }

    public void bind(final RegaloFromWS regaloFromWS, final OnItemClickListener listener) {
        itemName.setText(regaloFromWS.getName());
        price.setText("$" + regaloFromWS.getPrice());
        Glide.with(App.getContext()).load(regaloFromWS.getUrl_image()).placeholder(R.drawable.regalo).error(R.drawable.regalo).dontAnimate().into(itemImage);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(regaloFromWS);
            }
        });
    }
}
