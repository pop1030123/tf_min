package com.pop.tf_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pop.tf_min.R;
import com.pop.tf_min.entity.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengfu on 15/11/7.
 */
public class RowAdapter extends RecyclerView.Adapter<MyRowHolder> {


    private Context mContext;
    private List<Note> mListData = new ArrayList<>();

    private OnItemClickListener mListener ;

    public RowAdapter(Context context, List<Note> datas ,OnItemClickListener listener) {
        mContext = context;
        mListData = datas;
        mListener = listener ;
    }

    @Override
    public MyRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyRowHolder(LayoutInflater.from(mContext).inflate(R.layout.row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyRowHolder holder, int position) {
        Note data = mListData.get(position);
        holder.textView.setText(data.getContent());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(v, mListData.get(holder.getAdapterPosition()));
            }
        });
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



