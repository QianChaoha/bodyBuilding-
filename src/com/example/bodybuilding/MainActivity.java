package com.example.bodybuilding;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bodybuilding.base.BaseActivity;
import com.example.bodybuilding.util.ScreenUtil;

public class MainActivity extends BaseActivity {
    private LinearLayout mLinearLayout;
    private int mCurrentItem = 0;
    private int mWhat = 0;
    private int mTotal = 5;
    private TextView mTvSelectText;
    private final long DURATION=2000;
    private String[] selectTextArr = new String[]{
            "Select a workout or touch \"Quick Start\" to begin.",
            "Touch the i icon for complete workout descriptions.",
            "Ensure the bike is in the correct position and the Rotary Motion lever is locked down.",
            "Read and understand all safely information before starting workout.",
            "Visit www.avantifitness.com for additional workouts and exercise tips "
    };
    private boolean mIsFirst = true;
    private RelativeLayout mRl1, mRl2, mRl3, mRl4, mRl5;
    private RelativeLayout[] mRls = new RelativeLayout[5];
    private int[] mRlX = new int[5];
    private int[] mRlY = new int[5];
    private Handler mHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mTvSelectText.setText(selectTextArr[mCurrentItem]);
            mCurrentItem++;
            mCurrentItem = mCurrentItem % mTotal;

            for (int i = 0; i < mLinearLayout.getChildCount(); i++) {
                ImageView imageView = (ImageView) mLinearLayout.getChildAt(i);
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
        mRl1 = getView(R.id.rl1);
        mRl2 = getView(R.id.rl2);
        mRl3 = getView(R.id.rl3);
        mRl4 = getView(R.id.rl4);
        mRl5 = getView(R.id.rl5);
        mRls[0] = mRl1;
        mRls[1] = mRl2;
        mRls[2] = mRl3;
        mRls[3] = mRl4;
        mRls[4] = mRl5;
        for (int i = 0; i < mRls.length; i++) {
            mRls[i].setVisibility(View.GONE);
        }
        initList();
        mHandle.sendEmptyMessageAtTime(mWhat, 3000);
    }

    private void initList() {
        mLinearLayout.removeAllViews();
        for (int i = 0; i < 5; i++) {
            ImageView imageView = new ImageView(mContext);
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.grey_stage_1_64);
            } else {
                imageView.setBackgroundResource(R.drawable.black_stage_1_56);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ScreenUtil.dip2px(mContext, 10), ScreenUtil.dip2px(mContext, 10));
            mLinearLayout.addView(imageView, layoutParams);
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
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (mIsFirst) {
            mIsFirst = false;
//            for (int i = 0; i < mRlX.length; i++) {
//                mRlX[i] = (int) mRls[i].getX();
//                mRlY[i] = (int) mRls[i].getY();
//            }
            ObjectAnimator moveX =ObjectAnimator.ofFloat(mRls[0], "translationX", -500, 0);
            ObjectAnimator moveY = ObjectAnimator.ofFloat(mRls[0], "translationY", -100, 0);
            AnimatorSet animSet = new AnimatorSet();
            animSet.play(moveX).with(moveY);
            animSet.setDuration(DURATION);
            animSet.start();

            ObjectAnimator moveX1 =ObjectAnimator.ofFloat(mRls[1], "translationX", -100, 0);
            ObjectAnimator moveY1 = ObjectAnimator.ofFloat(mRls[1], "translationY", -500, 0);
            AnimatorSet animSet1 = new AnimatorSet();
            animSet1.play(moveX1).with(moveY1);
            animSet1.setDuration(DURATION);
            animSet1.start();

            ObjectAnimator moveY2 = ObjectAnimator.ofFloat(mRls[2], "translationY", -500, 0);
            AnimatorSet animSet2 = new AnimatorSet();
            animSet2.play(moveY2);
            animSet2.setDuration(DURATION);
            animSet2.start();

            ObjectAnimator moveX3 = ObjectAnimator.ofFloat(mRls[3], "translationX", -100, 0);
            ObjectAnimator moveY3 = ObjectAnimator.ofFloat(mRls[3], "translationY", -500, 0);
            AnimatorSet animSet3 = new AnimatorSet();
            animSet3.play(moveY3).with(moveX3);
            animSet3.setDuration(DURATION);
            animSet3.start();

            ObjectAnimator moveX4 = ObjectAnimator.ofFloat(mRls[4], "translationX", 500, 0);
            ObjectAnimator moveY4 = ObjectAnimator.ofFloat(mRls[4], "translationY", 100, 0);
            AnimatorSet animSet4 = new AnimatorSet();
            animSet4.play(moveY4).with(moveX4);
            animSet4.setDuration(DURATION);
            animSet4.start();

            for (int i = 0; i < mRls.length; i++) {
                mRls[i].setVisibility(View.VISIBLE);
            }
        }
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
