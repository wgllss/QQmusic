package com.qq.atar.qqmusic.adapter;

import android.activity.CommonActivity;
import android.adapter.CommonPagerAdapter;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qq.atar.qqmusic.moudle.SliderBean;

import java.util.List;

/**
 * Created by Atar on 2018/4/24.
 */

public class BannerAdapter extends CommonPagerAdapter<SliderBean> {

    public BannerAdapter(List<?> list) {
        super(list);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imgaeView = new ImageView(container.getContext());
        SliderBean info = getList().get(position);
        if (info != null) {
            String url = info.getPicUrl();
            if (url != null && url.length() > 0) {
                ((CommonActivity) container.getContext()).LoadImageView(url, imgaeView, 0, null, 0);
            }
        }
        container.addView(imgaeView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        return imgaeView;
    }
}
