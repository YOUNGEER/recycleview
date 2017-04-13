package com.wenyi.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.wenyi.recycleview.base.BaseAdapterActivity;

public class MainActivity extends AppCompatActivity {
    private TextView showAdapter;
    private TextView itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showAdapter = (TextView) findViewById(R.id.baseshow);
        itemTouchHelper = (TextView) findViewById(R.id.itemtouch);

        showAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BaseAdapterActivity.class));
            }
        });
    }
}
