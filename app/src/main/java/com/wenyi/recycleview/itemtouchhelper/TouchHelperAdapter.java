package com.wenyi.recycleview.itemtouchhelper;

import com.wenyi.recycleview.ListBean;
import com.wenyi.recycleview.R;
import com.wenyi.recycleview.base.BaseAdapter;
import com.wenyi.recycleview.base.ViewHolder;

import java.util.Collections;

/**
 * 作者：young on 2017/4/17 10:40
 */

public class TouchHelperAdapter extends BaseAdapter<ListBean> implements TouchHelperListener {
    @Override
    public int getLayoutId() {
        return R.layout.item_showbase;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, ListBean bean, int position) {
        holder.setText(R.id.tv_name, bean.getName());
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mData, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        removeAItemData(position);
    }
}
