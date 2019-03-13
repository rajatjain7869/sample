package com.example.core;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    //public abstract void onBind(List item, int pos);
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
//        ButterKnife.bind(this, itemView);

    }
}
