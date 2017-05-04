package com.example.bodybuilding;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.bodybuilding.adapter.MainViewPagerAdapter;
import com.example.bodybuilding.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private ViewPager mViewPager;
    private List<ImageView> mList = new ArrayList<ImageView>();
    private MainViewPagerAdapter mainViewPagerAdapter;
    private int mCurrentItem=0;
    private int mWhat=0;
    private Handler mHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mCurrentItem++;
            mCurrentItem=(mCurrentItem>=mViewPager.getCurrentItem())?0:mCurrentItem;
            mViewPager.setCurrentItem(mCurrentItem);
            List<ImageView> mList=mainViewPagerAdapter.getmList();
            if (mList!=null){
                for (int i = 0; i < mList.size(); i++) {
                    if (i==mCurrentItem){
                        mList.get(i).setBackgroundResource(R.drawable.grey_stage_1_64);
                    }else {
                        mList.get(i).setBackgroundResource(R.drawable.black_stage_1_56);
                    }
                }
            }
            if (mHandle!=null){
                mHandle.sendEmptyMessageAtTime(mWhat,3000);
            }

        }
    };

    @Override
    protected void initView() {
        mViewPager = getView(R.id.viewPager);
        initList();
        mainViewPagerAdapter = new MainViewPagerAdapter(this, mList);
        mViewPager.setAdapter(mainViewPagerAdapter);
        mHandle.sendEmptyMessageAtTime(mWhat,3000);
    }

    private void initList() {
        for (int i = 0; i < 5; i++) {
            ImageView imageView = new ImageView(this);
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.grey_stage_1_64);
            } else {
                imageView.setBackgroundResource(R.drawable.black_stage_1_56);
            }
            mList.add(imageView);
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
        if (mHandle!=null){
            mHandle.removeMessages(mWhat);
            mHandle=null;
        }
    }
}
