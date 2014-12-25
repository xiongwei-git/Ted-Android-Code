package com.ted.AndroidSampleSet;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mSwipeLayout;
    private ListView mListView;
    private LinearLayout mLinearLayout;
    private ArrayList<String> list = new ArrayList<String>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

//        mListView = (ListView) findViewById(R.id.listview);
          mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);
//        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
//                getData()));
        getData();
        for(int i = 0;i<list.size();i++){
            TextView textView = new TextView(this);
            textView.setText(list.get(i));
            mLinearLayout.addView(textView);
        }

        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    private ArrayList<String> getData() {
        list.add("Hello");
        list.add("This is stormzhang");
        list.add("An Android Developer");
        list.add("Love Open Source");
        list.add("My GitHub: stormzhang");
        list.add("weibo: googdev");
        list.add("Hello");
        list.add("This is stormzhang");
        return list;
    }

    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeLayout.setRefreshing(false);
            }
        }, 5000);
    }
}
