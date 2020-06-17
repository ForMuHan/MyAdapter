package com.syw.adapterlib.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Description:
 * Created by Administrator on 2019/3/21
 */
public class ViewHolder extends RecyclerView.ViewHolder{

    private ViewDataBinding binding;

    public ViewDataBinding getBinding() {
        return binding;
    }

    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }

    public ViewHolder(View itemView) {
        super(itemView);
    }
}
