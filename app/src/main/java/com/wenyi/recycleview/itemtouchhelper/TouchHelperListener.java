package com.wenyi.recycleview.itemtouchhelper;

/**
 * 作者：young on 2017/4/17 10:42
 */

public interface TouchHelperListener {
    //交换
    void onItemMove(int fromPosition, int toPosition);

    //滑动删除
    void onItemDismiss(int position);
}
