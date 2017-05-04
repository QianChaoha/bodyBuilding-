package com.example.bodybuilding;

import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bodybuilding.base.BaseActivity;
import com.example.bodybuilding.util.ScreenUtil;

public class MainActivity extends BaseActivity {
    private LinearLayout mLinearLayout;
    private int mCurrentItem = 0;
    private int mWhat = 0;
    private int mTotal = 5;
    private TextView mTvSelectText;
    private String[] selectTextArr=new String[]{
    		"Select a workout or touch \"Quick Start\" to begin.",
    		"Touch the i icon for complete workout descriptions.",
    		"Ensure the bike is in the correct position and the Rotary Motion lever is locked down.",
    		"Read and understand all safely information before starting workout.",
    		"Visit www.avantifitness.com for additional workouts and exercise tips "
    };
    private Handler mHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	mTvSelectText.setText(selectTextArr[mCurrentItem]);
            mCurrentItem++;
            mCurrentItem = mCurrentItem%mTotal;

            for (int i = 0; i < mLinearLayout.getChildCount(); i++) {
                ImageView imageView= (ImageView) mLinearLayout.getChildAt(i);
                    if (i == mCurrentItem) {
                        imageView.setBackgroundResource(R.drawable.grey_stage_1_64);
                    } else {
                        imageView.setBackgroundResource(R.drawable.black_stage_1_56);
                    }
            }
            if (mHandle != null) {
                mHandle.sendEmptyMessageDelayed(mWhat, 3000);
            }

        }
    };

    @Override
    protected void initView() {
        mLinearLayout = getView(R.id.linearLayout);
        mTvSelectText = getView(R.id.tvSelectText);
        initList();
        mHandle.sendEmptyMessageAtTime(mWhat, 3000);
    }

    private void initList() {
        mLinearLayout.removeAllViews();
        for (int i = 0; i < 5; i++) {
            ImageView imageView= new ImageView(mContext);
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.grey_stage_1_64);
            } else {
                imageView.setBackgroundResource(R.drawable.black_stage_1_56);
            }
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ScreenUtil.dip2px(mContext, 10), ScreenUtil.dip2px(mContext, 10));
            mLinearLayout.addView(imageView,layoutParams);
        }

    }

    @Override
    protected void getData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.main;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHandle != null) {
            mHandle.removeMessages(mWhat);
            mHandle = null;
        }
    }
}
