package com.example.bodybuilding.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import com.example.bodybuilding.R;
import com.example.bodybuilding.adapter.SelectLanguageAdapter;
import com.example.bodybuilding.adapter.SelectWeightAdapter;
import com.example.bodybuilding.base.BaseActivity;

public class SelectWeightActivity extends BaseActivity {
	private TextView mTvTitle;
	private GridView mGridView;
	private Button btContinue;
	@Override
	protected void initView() {
		mTvTitle = getView(R.id.tvTitle);
		mGridView = getView(R.id.gridView);
		btContinue = getView(R.id.btContinue);
		btContinue.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(mContext,CustomWorkoutActivity.class));
			}
		});
	}

	@Override
	protected void getData() {
		List<Integer> list=new ArrayList<Integer>();
		list.add(10);
		list.add(15);
		list.add(20);
		list.add(25);
		list.add(30);
		list.add(35);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(70);
		list.add(null);
		list.add(null);
		mGridView.setAdapter(new SelectWeightAdapter(mContext, list));
	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_select_weight;
	}

}
