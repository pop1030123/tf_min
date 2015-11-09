package com.pop.tf_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pop.tf_min.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengfu on 15/11/7.
 */
public class DataAdapter extends RecyclerView.Adapter<MyViewHolder> {


    private Context mContext;
    private List<String> mListData = new ArrayList<String>();

    public DataAdapter(Context context, List<String> datas) {
        mContext = context;
        mListData = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mListData.get(position));
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public MyViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.id_num);
    }
}
