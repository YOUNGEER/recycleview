package com.wenyi.recycleview.itemtouchhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.wenyi.recycleview.ListBean;
import com.wenyi.recycleview.R;

import java.util.ArrayList;
import java.util.List;


public class TouchHelperActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private TouchHelperAdapter madapter;
    private List<ListBean> mBeen = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);

        //关键，LayoutManager是用来区别listivew，gradview不同效果的。
        LinearLayoutManager manager = new LinearLayoutManager(this);

        //默认是垂直，也可以设置成水平
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        //加载manager，体现了松耦合
        mRecyclerView.setLayoutManager(manager);
        for (int i = 0; i < 30; i++) {
            mBeen.add(new ListBean("zhangsan" + i + i));
        }
        madapter = new TouchHelperAdapter();
        //加载适配器
        mRecyclerView.setAdapter(madapter);

        //-------------item---------------------------
        ItemTouchHelper.Callback helper = new RecycleItemTouchHelper(madapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(helper);
        touchHelper.attachToRecyclerView(mRecyclerView);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        madapter.setDataList((ArrayList<ListBean>) mBeen);
    }
}
