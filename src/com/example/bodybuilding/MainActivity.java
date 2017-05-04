package com.example.bodybuilding;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.bodybuilding.adapter.MainViewPagerAdapter;
import com.example.bodybuilding.base.BaseActivity;
import com.example.bodybuilding.util.ScreenUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private LinearLayout mLinearLayout;
    private int mCurrentItem = 0;
    private int mWhat = 0;
    private int mTotal = 5;
    private Handler mHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
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
        initList();
        mHandle.sendEmptyMessageAtTime(mWhat, 3000);
    }

    private void initList() {
        mLinearLayout.removeAllViews();
        for (int i = 0; i < 5; i++) {
//            View view = View.inflate(mContext,R.layout.main_pager_item,null);
            ImageView imageView= new ImageView(mContext);
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.grey_stage_1_64);
            } else {
                imageView.setBackgroundResource(R.drawable.black_stage_1_56);
            }
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ScreenUtil.dip2px(mContext,50), ScreenUtil.dip2px(mContext,50));
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
