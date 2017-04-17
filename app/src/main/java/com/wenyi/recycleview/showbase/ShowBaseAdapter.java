package com.wenyi.recycleview.showbase;

import android.view.View;
import android.widget.TextView;

import com.wenyi.recycleview.ListBean;
import com.wenyi.recycleview.R;
import com.wenyi.recycleview.base.BaseAdapter;
import com.wenyi.recycleview.base.ViewHolder;

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

        //填加点击事件
        TextView tv = holder.getView(R.id.tv_name);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
