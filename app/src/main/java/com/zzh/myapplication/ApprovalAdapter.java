package com.zzh.myapplication;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

/**
 * Author: zzhh
 * Date: 2022/7/19 22:27
 * Description:
 */
public class ApprovalAdapter extends BaseQuickAdapter<Bean, BaseViewHolder> {

    private int focusPos;
    public ApprovalAdapter(@Nullable List<Bean> data) {
        super(R.layout.item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Bean item) {
//这里设置条目数据
        helper.setText(R.id.et, item.name);

        EditText et = helper.getView(R.id.et);
        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                return false;
            }
        });

        if (focusPos == getItemPosition(item)){
            et.requestFocus();
        }
    }

    public void setFocusPos(int pos){
        focusPos = pos;
    }
}