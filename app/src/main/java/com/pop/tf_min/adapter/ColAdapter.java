package com.pop.tf_min.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pop.tf_min.DividerItemDecoration;
import com.pop.tf_min.R;
import com.pop.tf_min.entity.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengfu on 15/11/7.
 */
public class ColAdapter extends RecyclerView.Adapter<MyColHolder> {


    private Context mContext;

    private int mDepth = 0  ;

    private Note mCurNote ;
    private OnItemClickListener mListener ;

    public ColAdapter(Context context, Note datas ,OnItemClickListener listener) {
        mContext = context;
        mCurNote = datas;
        mListener = listener ;
    }

    public Note getCurNote(){
        return mCurNote ;
    }
    public void setCurNote(Note note){
        mCurNote = note ;
        int tempDepth = 0 ;
        Note tempNote = note.getParent() ;
        while (tempNote!=null){
            tempNote = tempNote.getParent() ;
            tempDepth++ ;
        }
        mDepth = tempDepth ;
    }

    @Override
    public MyColHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyColHolder(LayoutInflater.from(mContext).inflate(R.layout.col_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyColHolder holder, int position) {
        List<Note> data = mCurNote.getChildren(mDepth ,position);
        RowAdapter adapter = new RowAdapter(mContext, data ,mListener);
        holder.colView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.colView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.HORIZONTAL_LIST));
        holder.colView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return mDepth + 1;
    }

}


class MyColHolder extends RecyclerView.ViewHolder {

    RecyclerView colView;

    public MyColHolder(View itemView) {
        super(itemView);
        colView = (RecyclerView) itemView.findViewById(R.id.list);
    }
}
