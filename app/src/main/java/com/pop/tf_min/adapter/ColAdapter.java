package com.pop.tf_min.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pop.tf_min.DividerItemDecoration;
import com.pop.tf_min.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengfu on 15/11/7.
 */
public class ColAdapter extends RecyclerView.Adapter<MyColHolder> {


    private Context mContext;
    private List<List<String>> mListData = new ArrayList<List<String>>();

    public ColAdapter(Context context, List<List<String>> datas) {
        mContext = context;
        mListData = datas;
    }

    @Override
    public MyColHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyColHolder(LayoutInflater.from(mContext).inflate(R.layout.col_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyColHolder holder, int position) {
        List<String> data = mListData.get(position);
        RowAdapter adapter = new RowAdapter(mContext, data);
        holder.colView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.colView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.HORIZONTAL_LIST));
        holder.colView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

}


class MyColHolder extends RecyclerView.ViewHolder {

    RecyclerView colView;

    public MyColHolder(View itemView) {
        super(itemView);
        colView = (RecyclerView) itemView.findViewById(R.id.list);
    }
}
