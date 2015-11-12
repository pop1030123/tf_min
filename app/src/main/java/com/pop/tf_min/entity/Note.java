package com.pop.tf_min.entity;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengfu on 15/11/10.
 */
public class Note {

    public static final String TAG = "Note:" ;

    private String content ;
    private Note parentNote ;
    private List<Note> childrenNote ;
    private boolean isRoot = false ;

    public Note(){
    }
    public Note(String content){
        this.content = content ;
    }

    public Note(String content ,Note parent){
        this.content = content ;
        this.parentNote = parent ;
    }

    public boolean isRoot(){
        return isRoot ;
    }
    public void setIsRoot(boolean isRoot){
        this.isRoot = isRoot ;
    }
    public void setContent(String content){
        this.content = content ;
    }
    public String getContent(){
        return this.content ;
    }

    public boolean isLeaf(){
        return childrenNote == null || childrenNote.size()==0 ;
    }

    public void addChild(Note child){
        if (child != null){
            if (childrenNote == null){
                childrenNote = new ArrayList<>() ;
            }
            childrenNote.add(child);
        }
    }

    public void removeChild(Note child){
        if (child != null) {
            if (childrenNote != null) {
                childrenNote.remove(child);
            }
        }
    }

    public void setParent(Note parent){
        this.parentNote = parent ;
    }
    public Note getParent(){
        return parentNote ;
    }
    public List<Note> getChildren(){
        return childrenNote ;
    }

    /**
     *
     * @param position
     * @return
     */
    public List<Note> getChildren(int depth ,int position){
        Log.d(TAG ,"getChildren:depth:"+depth+":position:"+position) ;
        Note temp = this;
        for (int i=depth ;i > position ;i--){
            temp = temp.getParent() ;
        }
        return temp.getChildren() ;
    }

    public static Note getTestData(){
        Note root = new Note("Root") ;
        root.setIsRoot(true);
        for (int i = 0;i<5 ;i++) {
            Note child = new Note("项目" + i, root);
            for (int j = 0; j < 3; j++) {
                Note child2 = new Note(i+"子项目" + j, child);
                child.addChild(child2);
            }
            root.addChild(child);
        }
        return root ;
    }
}
