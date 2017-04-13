package com.wenyi.recycleview.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：young on 2017/4/13 15:01
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    private LayoutInflater inflater;
    private int layoutId;
    private Context mContext;
    public List<T> mData;

    public abstract int getLayoutId();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (null == inflater) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        View item = inflater.inflate(getLayoutId(), null, false);
        return new ViewHolder(item);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        onBindViewHolder(holder, mData.get(position), position);
    }

    ;

    public abstract void onBindViewHolder(ViewHolder holder, T bean, int position);


    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    /**
     * 获取数据集合，便于Activity中调用
     *
     * @return
     */
    public List<T> getDataList() {
        return mData != null ? mData : new ArrayList<T>();
    }

    /**
     * 设置集合数据
     *
     * @param data
     */
    public void setDataList(ArrayList<T> data) {
        mData = data;
        notifyDataSetChanged();
    }

    /**
     * 添加集合数据，分页加载使用
     *
     * @param data
     */
    public void addDataList(ArrayList<T> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 添加某个数据notifyItemInserted才有动画效果
     *
     * @param item
     * @param poi
     */
    public void addAItemData(T item, int poi) {
        mData.add(item);
        notifyItemInserted(poi);
    }

    /**
     * 删除某个数据notifyItemRemoved才有动画效果
     *
     * @param poi
     */
    public void removeAItemData(int poi) {
        mData.remove(poi);
        notifyItemRemoved(poi);
    }
}
