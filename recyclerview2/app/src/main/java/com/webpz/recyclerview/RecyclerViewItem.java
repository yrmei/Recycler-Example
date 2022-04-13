package com.webpz.recyclerview;

import android.widget.LinearLayout;

public class RecyclerViewItem {
    private int mImgName;
    private String mMainText;
    private LinearLayout row;

    public int getImgName() {
        return mImgName;
    }

    public void setImgName(int imgName) {
        this.mImgName = imgName;
    }

    public String getMainText() {
        return mMainText;
    }

    public void setMainText(String mainText) {
        this.mMainText = mainText;
    }
    public void setRow(LinearLayout row) {
        this.row = row;
    }
    public LinearLayout getRow(){
        return row;
    }
}
