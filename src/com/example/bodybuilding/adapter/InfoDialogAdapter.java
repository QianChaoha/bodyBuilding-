package com.example.bodybuilding.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.example.bodybuilding.R;
import com.example.bodybuilding.base.BaseAdapter;
import com.example.bodybuilding.base.ViewHolder;

import java.util.List;

/**
 * Created by cqian on 2017/5/5.
 */
public class InfoDialogAdapter extends BaseAdapter<Integer> {


    public InfoDialogAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.info_img_item;
    }

    @Override
    protected void onViewCreated(ViewHolder holder, int position) {
        ImageView imageView = holder.get(R.id.imageView);
        imageView.setBackgroundResource(list.get(position));
    }
}
