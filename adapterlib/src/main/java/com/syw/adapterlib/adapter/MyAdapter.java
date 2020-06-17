package com.syw.adapterlib.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    /**
     * adapter数据源
     */
    private List<T> mDatas;
    /**
     * 布局id
     */
    private int layoutId;
    /**
     * 布局文件data中变量的BR值
     */
    private int brId;
    /**
     * item中某个view的id
     */
    private int[] viewIds;

    private OnViewClickListener viewListener;

    private ViewHolder viewHolder;

    /**
     * item中某个view的点击事件
     *
     * @param viewIds  点击view的id
     * @param listener 点击的监听回调
     */
    public void setOnViewClickListener(int[] viewIds, OnViewClickListener listener) {
        this.viewIds = viewIds;
        this.viewListener = listener;
    }

    /**
     * @param layoutId 布局文件id
     * @param brId     布局文件data中变量的BR值
     */
    public MyAdapter(int layoutId, int brId) {
        this.layoutId = layoutId;
        this.brId = brId;
    }

    public void setDatas(List<T> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        viewHolder = new ViewHolder(binding.getRoot());
        viewHolder.setBinding(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getBinding().setVariable(brId, mDatas.get(position));
        holder.getBinding().executePendingBindings();
        try {
            for (int i = 0; i < viewIds.length; i++) {
                View view = holder.getBinding().getRoot().findViewById(viewIds[i]);
                view.setOnClickListener(v -> {
                    if (viewListener != null) {
                        viewListener.onViewClick(view, holder.getAdapterPosition());
                    }
                });
            }
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public interface OnViewClickListener {
        void onViewClick(View view, int position);
    }

}
