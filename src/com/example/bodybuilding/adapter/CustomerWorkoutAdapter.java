package com.example.bodybuilding.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bodybuilding.R;
import com.example.bodybuilding.base.BaseAdapter;
import com.example.bodybuilding.base.ViewHolder;
import com.example.bodybuilding.entity.CustomerWorkoutEntity;
import java.util.List;

/**
 * Created by cqian on 2017/5/9.
 */
public class CustomerWorkoutAdapter extends BaseAdapter<CustomerWorkoutEntity> {
    public CustomerWorkoutAdapter(Context context, List<CustomerWorkoutEntity> list) {
        super(context, list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.customer_workout_item;
    }

    @Override
    protected void onViewCreated(ViewHolder holder, int position) {
        TextView tvContent=holder.get(R.id.tvContent);
        tvContent.setText(getItem(position).mText);
        ImageView imageView=holder.get(R.id.imageView);
        imageView.setBackgroundResource(getItem(position).mImageId);
    }
}
