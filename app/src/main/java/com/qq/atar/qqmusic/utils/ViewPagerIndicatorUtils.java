package com.qq.atar.qqmusic.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.utils.ScreenUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qq.atar.qqmusic.R;


/**
 * Created by atar on 2018/3/27 0027.
 */

public class ViewPagerIndicatorUtils {
    public static void initIndicator(Context context, int listSize, ViewPager viewPager, LinearLayout ad_indicator) {
        if (context == null || ad_indicator == null) {
            return;
        }
        if (listSize > 1) {
            ad_indicator.removeAllViews();
            for (int i = 0; i < listSize; i++) {
                ImageView imagerView = new ImageView(context);
                int size = (int) ScreenUtils.getIntToDip(12);
                imagerView.setLayoutParams(new LinearLayout.LayoutParams(size, size));
                imagerView.setPadding(5, 0, 5, 0);
                imagerView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                if (i == 0) {
                    imagerView.setImageResource(R.mipmap.jinr02);
                } else {
                    imagerView.setImageResource(R.mipmap.jinr011);
                }
                ad_indicator.addView(imagerView);
            }
            ad_indicator.setVisibility(View.VISIBLE);
            final LinearLayout indicator = ad_indicator;
            viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    if (indicator != null) {
                        for (int i = 0; i < indicator.getChildCount(); i++) {
                            if (i == position) {
                                if (indicator.getChildCount() > 0 && indicator.getChildAt(i) != null) {
                                    ((ImageView) indicator.getChildAt(i)).setImageResource(R.mipmap.jinr02);
                                }
                            } else {
                                if (indicator.getChildCount() > 0 && indicator.getChildAt(i) != null) {
                                    ((ImageView) indicator.getChildAt(i)).setImageResource(R.mipmap.jinr011);
                                }
                            }
                        }
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        } else {
            ad_indicator.setVisibility(View.GONE);
        }
    }

    public static void setAutoPlay(final ViewPager viewPager) {
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (viewPager != null && viewPager.getChildCount() > 0) {
                    int index = viewPager.getCurrentItem();
                    if (index < viewPager.getChildCount()) {
                        index++;
                    } else {
                        index = 0;
                    }
                    viewPager.setCurrentItem(index, true);
                }
                sendEmptyMessageDelayed(0, 3000);
            }
        };
        handler.sendEmptyMessageDelayed(0, 3000);
    }
}
