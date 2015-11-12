package com.pop.tf_min;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pop.tf_min.adapter.ColAdapter;
import com.pop.tf_min.entity.Note;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.act_main)
public class MainActivity extends Activity {

    @ViewById(R.id.list)
    RecyclerView mDataView;

    private Note mDatas;

    private ColAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        initData();
        mAdapter = new ColAdapter(this, mDatas);
    }

    private void initData() {
        mDatas = Note.getTestData()  ;
    }

    @AfterViews
    void afterViews() {
        mDataView.setLayoutManager(new LinearLayoutManager(this));
        mDataView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mDataView.setAdapter(mAdapter);
    }

}
