package com.wenyi.recycleview.itemtouchhelper;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

/**
 * 作者：young on 2017/4/17 10:39
 */

public class RecycleItemTouchHelper extends ItemTouchHelper.Callback {

    private TouchHelperAdapter mAdapter;

    public RecycleItemTouchHelper(TouchHelperAdapter madapter) {

        this.mAdapter = madapter;
    }

    /**
     * 设置滑动类型标记
     *
     * @param recyclerView
     * @param viewHolder
     * @return 返回一个整数类型的标识，用于判断Item那种移动行为是允许的
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        /**
         * START  右向左
         * END  左向右
         * LEFT  向左
         * RIGHT 向右
         * UP  向上
         * 如果某个值传0，表示不触发该操作，次数设置支持上下拖拽，支持向右滑动
         */

        return makeMovementFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.END | ItemTouchHelper.START);
    }

    /**
     * 拖拽切换item的回调
     *
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return true切换了拖拽  false 没有切换
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        mAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    /**
     * 滑动的回调
     *
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    /**
     * 是否支持长按拖拽
     *
     * @return
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    /**
     * item是否支持滑动
     *
     * @return
     */
    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    /**
     * 恢复到原状态，没有消失
     *
     * @param recyclerView
     * @param viewHolder
     */
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        Log.i("sssssssss1", "11111");
    }

    /**
     * @param viewHolder
     * @param actionState 0正在侧滑 1释放
     */
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        Log.i("sssssssss2", "22222" + actionState);
//        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
//            viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
//        }
    }

    /**
     * item滑动
     *
     * @param c
     * @param recyclerView
     * @param viewHolder
     * @param dX
     * @param dY
     * @param actionState
     * @param isCurrentlyActive
     */
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        Log.i("sssssssss3", "3333" + isCurrentlyActive);
    }

    /**
     * 滑动停止
     *
     * @param c
     * @param recyclerView
     * @param viewHolder
     * @param dX
     * @param dY
     * @param actionState
     * @param isCurrentlyActive
     */
    @Override
    public void onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        Log.i("sssssssss4", "4444" + dY);
    }
}