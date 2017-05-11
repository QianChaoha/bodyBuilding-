package com.example.bodybuilding.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bodybuilding.R;
import com.example.bodybuilding.base.BaseActivity;
import com.example.bodybuilding.interfaces.DialogCallback;
import com.example.bodybuilding.view.WorkoutSummaryDialog;

/**
 * Created by cqian on 2017/5/11.
 */
public class WorkoutScreenActivity extends BaseActivity {
    private TextView mTvStart;
    private RelativeLayout mRlStart;
    private ImageView mIvAnim, mIvPausePlay, mIvStartPlay;
    private AnimationDrawable mAnim;
private LinearLayout mLlColor;
    @Override
    protected void initView() {
        mTvStart = getView(R.id.tvStart);
        mIvPausePlay = getView(R.id.ivPausePlay);
        mIvStartPlay = getView(R.id.ivStartPlay);
        mRlStart = getView(R.id.rlStart);
        mLlColor = getView(R.id.llColor);
        mIvAnim = getView(R.id.ivAnim);


        for (int i = 0; i < 20; i++) {
            LinearLayout linearLayout=new LinearLayout(mContext);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0);
            layoutParams.weight=1;
            for (int j = 0; j < 30; j++) {
                TextView textView=new TextView(mContext);
                if (i<3){
                    textView.setBackgroundColor(Color.RED);
                }else if (i<7){
                    textView.setBackgroundColor(Color.YELLOW);
                }else {
                    textView.setBackgroundColor(Color.GREEN);
                }
                LinearLayout.LayoutParams layoutParams1=new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.MATCH_PARENT);
                layoutParams1.weight=1;
                layoutParams1.setMargins(1,1,1,1);
                linearLayout.addView(textView,layoutParams1);
            }
            mLlColor.addView(linearLayout,layoutParams);
        }


        final ScaleAnimation scaleAnimation = new ScaleAnimation(1, 0.5f, 1, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        final ScaleAnimation scaleAnimationEnd = new ScaleAnimation(1, 0.2f, 1, 0.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimationEnd.setDuration(1000);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


            }

            @Override
            public void onAnimationEnd(Animation animation) {
                try {
                    int temp = Integer.valueOf(mTvStart.getText().toString());
                    if (temp > 0) {
                        temp--;
                        mTvStart.setText(temp + "");
                        mTvStart.startAnimation(scaleAnimation);
                    } else {
                        mTvStart.setTextSize(TypedValue.COMPLEX_UNIT_SP, 120);
                        mTvStart.setText("GO");
                        mTvStart.startAnimation(scaleAnimationEnd);
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        scaleAnimationEnd.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mRlStart.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mTvStart.startAnimation(scaleAnimation);
        mIvPausePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnim != null && mAnim.isRunning()) {
                    mAnim.stop();
                    WorkoutSummaryDialog dialog=new WorkoutSummaryDialog(mContext, new DialogCallback() {
						
						@Override
						public void click(View view) {
							
						}
					});
                }
            }
        });

        mIvStartPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnim != null && !mAnim.isRunning()) {
                    mAnim.start();
                }
            }
        });


        mAnim = new AnimationDrawable();
        for (int i = 1; i <= 6; i++) {
//            k_countdown_middle_img_back
//            k_countdown_middle_img_biceps
//            k_countdown_middle_img_kayak
//            k_countdown_middle_img_seated
//            k_countdown_middle_img_shoulder
//            k_countdown_middle_img_triceps
            mAnim.addFrame(getResources().getDrawable(R.drawable.k_countdown_middle_img_back), 500);
            mAnim.addFrame(getResources().getDrawable(R.drawable.k_countdown_middle_img_biceps), 500);
//            anim.addFrame(getResources().getDrawable(R.drawable.k_countdown_middle_img_kayak), 200);
//            anim.addFrame(getResources().getDrawable(R.drawable.k_countdown_middle_img_seated), 200);
//            anim.addFrame(getResources().getDrawable(R.drawable.k_countdown_middle_img_shoulder), 200);
//            anim.addFrame(getResources().getDrawable(R.drawable.k_countdown_middle_img_triceps), 200);
        }
        mAnim.setOneShot(false);
        mIvAnim.setImageDrawable(mAnim);
        mAnim.start();

    }

    @Override
    protected void getData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_workout_screen;
    }
}
