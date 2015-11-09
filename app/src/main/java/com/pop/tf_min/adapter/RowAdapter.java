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
public class RowAdapter extends RecyclerView.Adapter<MyRowHolder> {


    private Context mContext;
    private List<String> mListData = new ArrayList<String>();

    public RowAdapter(Context context, List<String> datas) {
        mContext = context;
        mListData = datas;
    }

    @Override
    public MyRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyRowHolder(LayoutInflater.from(mContext).inflate(R.layout.row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyRowHolder holder, int position) {
        String data = mListData.get(position);
        holder.textView.setText(data);
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }
}


class MyRowHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public MyRowHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.id_num);
    }
}

