package com.pop.tf_min;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.pop.tf_min.adapter.ColAdapter;
import com.pop.tf_min.adapter.OnItemClickListener;
import com.pop.tf_min.entity.Note;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.act_main)
public class MainActivity extends Activity implements OnItemClickListener {

    public static final String TAG = "Note:" ;
    @ViewById(R.id.list)
    RecyclerView mDataView;

    private Note mDatas;

    private ColAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        initData();
        mAdapter = new ColAdapter(this, mDatas ,this);
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

    @Override
    public void onClick(View view, Note note) {
        App.getInstance().showToast(note.getContent());
        Log.d(TAG, "onClick:" + mAdapter.getCurNote() + ":note:" + note) ;
        if(mAdapter.getCurNote() == note){
            mAdapter.setCurNote(note.getParent());
        }else{
            mAdapter.setCurNote(note);
        }
        mAdapter.notifyDataSetChanged();
    }
}
