package com.wenyi.recycleview.base;

import com.wenyi.recycleview.ListBean;
import com.wenyi.recycleview.R;

/**
 * 作者：young on 2017/4/13 17:10
 */

public class ShowBaseAdapter extends BaseAdapter<ListBean> {
    @Override
    public int getLayoutId() {
        return R.layout.item_showbase;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, ListBean bean, int position) {
        holder.setText(R.id.tv_name, bean.getName());
    }
}
