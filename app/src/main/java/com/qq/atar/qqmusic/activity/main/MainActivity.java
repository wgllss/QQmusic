package com.qq.atar.qqmusic.activity.main;

import android.skin.SkinUtils;

import com.qq.atar.qqmusic.R;
import com.qq.atar.qqmusic.activity.QQmusicCommonTabActivity;
import com.qq.atar.qqmusic.fragment.RecommendFragment;

public class MainActivity extends QQmusicCommonTabActivity {

    @Override
    protected void initValue() {
        super.initValue();
        setActivityTitle("QQ音乐");
        setTextTab(SkinUtils.getStringArray(this, R.string.array_string_home_tabs_array), false, true);
        setOnDrawerBackEnabled(false);
        addFragmentToList(new RecommendFragment());
        addFragmentToList(new RecommendFragment());
        addFragmentToList(new RecommendFragment());
        setViewPagerAdapter();
    }

    @Override
    public void onBackPressed() {
        runOnBackground();
    }
}
