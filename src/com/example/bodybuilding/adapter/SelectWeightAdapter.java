package com.example.bodybuilding.adapter;

import java.util.List;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bodybuilding.R;
import com.example.bodybuilding.base.BaseAdapter;
import com.example.bodybuilding.base.ViewHolder;

public class SelectWeightAdapter extends BaseAdapter<Integer> {

	public SelectWeightAdapter(Context context, List<Integer> list) {
		super(context, list);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.select_weight_item;
	}

	@Override
	protected void onViewCreated(ViewHolder holder, int position) {
		TextView textView=holder.get(R.id.textView);
		textView.setText(getItem(position)+"");
	}

}
