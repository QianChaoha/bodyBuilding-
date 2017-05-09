package com.example.bodybuilding.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bodybuilding.R;
import com.example.bodybuilding.base.BaseActivity;
import com.example.bodybuilding.base.BaseAdapter;
import com.example.bodybuilding.base.ViewHolder;
import com.example.bodybuilding.entity.CustomerWorkoutEntity;

/**
 * Created by cqian on 2017/5/9.
 */
public class HeartrateActivity extends BaseActivity {
	private LinearLayout mRoot;
	private FrameLayout mFlHead;
	private ImageView mIvLeftArrow, mIvRightArrow;
	private ViewPager mViewPager;

	@Override
	protected void initView() {
		mRoot = getView(R.id.root);
		mFlHead = getView(R.id.flHead);
		mIvLeftArrow = getView(R.id.ivLeftArrow);
		mViewPager = getView(R.id.viewPager);
		mIvLeftArrow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		mIvRightArrow = getView(R.id.ivRightArrow);
		mIvRightArrow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		View viewHead = View.inflate(mContext, R.layout.heart_rate_top, null);
		mFlHead.removeAllViews();
		mFlHead.addView(viewHead);

		View viewOne = View.inflate(mContext, R.layout.heart_rate_one_view, null);

		View viewTwo = View.inflate(mContext, R.layout.heart_rate_two_view, null);
		GridView gridView = getView(viewTwo, R.id.gridView);
		
		List<CustomerWorkoutEntity> list1=new ArrayList<CustomerWorkoutEntity>();
		list1.add(new CustomerWorkoutEntity(R.drawable.i_but_manual_n, "Manual"));
		list1.add(new CustomerWorkoutEntity(R.drawable.i_but_pyramid_n, "Pyramid"));
		list1.add(new CustomerWorkoutEntity(R.drawable.i_but_hillclimb_n, "Hill Climb"));
		list1.add(new CustomerWorkoutEntity(R.drawable.i_but_interval_n, "Interval"));
		list1.add(new CustomerWorkoutEntity(R.drawable.i_but_random_n, "Random"));
		list1.add(new CustomerWorkoutEntity(R.drawable.i_but_constant_n, "Constant WATTS"));
		list1.add(new CustomerWorkoutEntity(R.drawable.i_but_heart_n, "Heart Rate"));
//		list1.add(new CustomerWorkoutEntity(R.drawable.i_but_manual_n, "Manual"));
		gridView.setAdapter(new HeartRateTwoAdapter(mContext,list1));
		
		View viewThree = View.inflate(mContext, R.layout.heart_rate_three_view, null);
		List<View> list = new ArrayList<View>();
		mViewPager.setAdapter(new MyPagerAdapter(mContext, list));
	}

	@Override
	protected void getData() {

	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_heart_rate;
	}

	class HeartRateTwoAdapter extends BaseAdapter<CustomerWorkoutEntity> {

		public HeartRateTwoAdapter(Context context, List<CustomerWorkoutEntity> list) {
			super(context, list);
		}

		@Override
		protected int getLayoutId() {
			return R.layout.heart_rate_two;
		}

		@Override
		protected void onViewCreated(ViewHolder holder, int position) {
			TextView tvContent=holder.get(R.id.tvContent);
			tvContent.setText(getItem(position).mText);
			ImageView imageView=holder.get(R.id.imageView);
			imageView.setBackgroundResource(getItem(position).mImageId);
		}

	}

	class MyPagerAdapter extends PagerAdapter {
		private List<View> mList;

		public MyPagerAdapter(Context context, List<View> list) {
			mContext = context;
			mList = list;
		}

		@Override
		public int getCount() {
			return mList.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object o) {
			return view.equals(o);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ViewPager viewPager = (ViewPager) container;
			View view = mList.get(position);
			// ViewGroup.LayoutParams layoutParams=new
			// ViewGroup.LayoutParams(ScreenUtil.dip2px(mContext,30),ScreenUtil.dip2px(mContext,30));
			viewPager.addView(view);
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			ViewPager viewPager = (ViewPager) container;
			viewPager.removeViewAt(position);
		}
	}
}
