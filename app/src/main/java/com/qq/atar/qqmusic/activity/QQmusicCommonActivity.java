package com.qq.atar.qqmusic.activity;

import android.activity.CommonActivity;
import android.annotation.SuppressLint;
import android.application.CrashHandler;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.interfaces.NetWorkCallListener;
import android.interfaces.OnOpenDrawerCompleteListener;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.reflection.NetWorkMsg;
import android.skin.SkinUtils;
import android.utils.ScreenUtils;
import android.utils.ShowLog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qq.atar.qqmusic.R;
import com.qq.atar.qqmusic.utils.IntentUtil;

/**
 *
 */

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :Atar
 * @createTime:2017-8-9下午2:31:05
 * @version:1.0.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: https://github.com/wgllss/atar-demo.git
 * ****************************************************************************************************************************************************************************
 */
@SuppressLint("InlinedApi")
public class QQmusicCommonActivity extends CommonActivity implements
        OnClickListener, NetWorkCallListener, OnOpenDrawerCompleteListener {
    private String TAG = QQmusicCommonActivity.class.getSimpleName();

    protected ImageView imgCommonTopLeft;
    protected ImageView imgCommonTopRight;
    protected TextView txtCommonTopTitle;
    private boolean commonTopLeftIsBack = true; // 顶部左边默认点击事件为返回
    protected RelativeLayout topTitleBarBg;
    protected View commonContentBg;
    protected TextView txtCommonTopRight;
    public TextView txtCommonTopLeft;
    protected TextView txtActivityRightTxt;
    private LinearLayout linearLoading;
    private TextView txt_loading_notice;
    /* 是否需要该父类所有布局 */
    private boolean isExtendsQQmusicCommonActivity = true;
    /* android 4.4+上状态栏默认透明 */
    protected boolean isFlagTranslucentStatus = true;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setOnOpenDrawerCompleteListener(this);
        if (VERSION.SDK_INT >= VERSION_CODES.KITKAT && isFlagTranslucentStatus) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        if (isExtendsQQmusicCommonActivity) {
            setContentView(R.layout.activity_common);
            txtCommonTopTitle = (TextView) findViewById(R.id.txt_common_top_title);
            imgCommonTopLeft = (ImageView) findViewById(R.id.img_common_top_left);
            imgCommonTopRight = (ImageView) findViewById(R.id.img_common_top_right);
            txtCommonTopRight = (TextView) findViewById(R.id.txt_common_top_right);
            txtCommonTopLeft = (TextView) findViewById(R.id.txt_common_top_left);
            txtActivityRightTxt = (TextView) findViewById(R.id.txt_common_top_title_right_txt);
            topTitleBarBg = (RelativeLayout) findViewById(R.id.common_top_title_bar);
            linearLoading = (LinearLayout) findViewById(R.id.linear_loading);
            txt_loading_notice = (TextView) findViewById(R.id.txt_loading_notice);
            imgCommonTopLeft.setOnClickListener(this);
            imgCommonTopRight.setOnClickListener(this);
            txtCommonTopRight.setOnClickListener(this);
            txtActivityRightTxt.setOnClickListener(this);
            txtCommonTopLeft.setOnClickListener(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // AtarPushTool.getInstance().bindPush();
        // android.app.ActivityManager activityManager =
        // (android.app.ActivityManager) getSystemService(ACTIVITY_SERVICE);
        // android.app.ActivityManager.MemoryInfo info = new
        // android.app.ActivityManager.MemoryInfo();
        // activityManager.getMemoryInfo(info);
        // ShowLog.i(TAG, "app占用总内存：" + "---" +
        // Runtime.getRuntime().totalMemory() / 1024 / 1024);
        // ShowLog.i(TAG, "系统剩余内存:" + "---" + Runtime.getRuntime().freeMemory()
        // / 1024 / 1024);
        // ShowLog.i(TAG, "系统是否处于低内存运行：" + info.lowMemory);
        // ShowLog.i(TAG, "当系统剩余内存低于----" + info.threshold / 1024 / 1024 +
        // "-----时就看成低内存运行---" + Runtime.getRuntime().maxMemory() / 1024 /
        // 1024);
    }

    @Override
    protected void OnRunBackground(boolean isOnBackGround) {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_common_top_left:// 顶部左边
                if (commonTopLeftIsBack) {
                    IntentUtil.finish(this);
                }
                break;
            case R.id.img_common_top_right:// 顶部右边图片
                break;
            case R.id.txt_common_top_right:// 顶部右边文字
                break;
            default:
                break;
        }
    }

    /**
     * 添加中间布局
     *
     * @param layoutResId
     * @author :Atar
     * @createTime:2014-6-13下午9:07:25
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    protected void addContentView(int layoutResId) {
        if (isExtendsQQmusicCommonActivity) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            commonContentBg = inflater.inflate(layoutResId, null);
            LayoutParams lp = new LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            lp.gravity = Gravity.TOP | Gravity.LEFT;
            if (VERSION.SDK_INT >= VERSION_CODES.KITKAT
                    && topTitleBarBg != null && isFlagTranslucentStatus) {
                int statusBarHeight = ScreenUtils.getStatusBarHeight(this);
                int layoutHeight = (statusBarHeight > 0 ? statusBarHeight : 36)
                        + (int) ScreenUtils.getIntToDip(45);
                topTitleBarBg.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, layoutHeight));
                topTitleBarBg.setPadding(0, statusBarHeight, 0, 0);
                lp.topMargin = layoutHeight;
            } else {
                lp.topMargin = (int) ScreenUtils.getIntToDip(45);
            }
            addContentView(commonContentBg, lp);
            if (linearLoading != null) {
                linearLoading.bringToFront();
            }
            init();
        }
    }

    /**
     * 设置中间布局 无顶部条
     *
     * @param layoutResId
     * @author :Atar
     * @createTime:2015-6-23下午1:38:49
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    protected void setContentLayout(int layoutResId) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        commonContentBg = inflater.inflate(layoutResId, null);
        LayoutParams lp = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        lp.gravity = Gravity.TOP | Gravity.LEFT;
        addContentView(commonContentBg, lp);
        if (linearLoading != null) {
            linearLoading.bringToFront();
        }
        init();
    }

    /**
     * 设置Activity顶部标题
     *
     * @param strTitile
     * @author :Atar
     * @createTime:2014-6-13下午9:07:51
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    protected void setActivityTitle(String strTitile) {
        if (txtCommonTopTitle != null)
            txtCommonTopTitle.setText(strTitile);
    }

    /**
     * 设置Activity顶部标题
     *
     * @param resStringID
     * @author :Atar
     * @createTime:2015-6-10上午10:47:04
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    protected void setActivityTitle(int resStringID) {
        if (txtCommonTopTitle != null && isExtendsQQmusicCommonActivity)
            txtCommonTopTitle.setText(getResources().getString(resStringID));
    }

    /**
     * 隐藏整个顶部公共布局
     *
     * @author :Atar
     * @createTime:2014-6-13下午9:01:06
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    public void setTitleBarGone() {
        if (commonContentBg != null) {
            LayoutParams lp = (LayoutParams) commonContentBg.getLayoutParams();
            if (VERSION.SDK_INT >= VERSION_CODES.KITKAT
                    && isFlagTranslucentStatus) {
                int statusBarHeight = ScreenUtils.getStatusBarHeight(this);
                topTitleBarBg.setPadding(0, statusBarHeight, 0, 0);
                lp.topMargin = statusBarHeight;
            } else {
                lp.topMargin = 0;
                topTitleBarBg.setVisibility(View.GONE);
            }
            commonContentBg.setLayoutParams(lp);
        }
    }

    /**
     * 隐藏顶部左边
     *
     * @author :Atar
     * @createTime:2014-6-13下午9:03:42
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    protected void setTopLeftViewGone() {
        if (imgCommonTopLeft != null)
            imgCommonTopLeft.setVisibility(View.GONE);
    }

    /**
     * 隐藏顶部右边
     *
     * @author :Atar
     * @createTime:2014-6-13下午9:04:48
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    protected void setTopRightViewGone() {
        if (imgCommonTopRight != null)
            imgCommonTopRight.setVisibility(View.GONE);
    }

    /**
     * 显示顶部右边图片
     *
     * @author :Atar
     * @createTime:2014-10-22下午5:12:17
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    protected void setTopRightViewVisible() {
        if (imgCommonTopRight != null)
            imgCommonTopRight.setVisibility(View.VISIBLE);
    }

    /**
     * 设置左边图片
     *
     * @author :Atar
     * @createTime:2014-7-1下午4:33:22
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    protected void setLeftImageDrawable(Drawable drawable) {
        if (imgCommonTopLeft != null) {
            imgCommonTopLeft.setImageDrawable(drawable);
            imgCommonTopLeft.setVisibility(View.VISIBLE);
            if (txtCommonTopLeft != null) {
                txtCommonTopLeft.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 设置顶部左边文字
     *
     * @param strLeftText
     * @author :Atar
     * @createTime:2015-3-26下午1:29:45
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    protected void setTopLeftText(String strLeftText) {
        if (txtCommonTopLeft != null) {
            txtCommonTopLeft.setText(strLeftText);
            txtCommonTopLeft.setVisibility(View.VISIBLE);
            if (imgCommonTopLeft != null) {
                imgCommonTopLeft.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 设置顶部中间左边文字右边图片
     *
     * @param strTitle
     * @param drawable
     * @author :Atar
     * @createTime:2015-2-10下午4:15:23
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    protected void setTopTitle(String strTitle, Drawable drawable) {
        if (txtCommonTopTitle != null) {
            if (strTitle != null) {
                txtCommonTopTitle.setText(strTitle);
            }
            txtCommonTopTitle.setCompoundDrawablesWithIntrinsicBounds(null,
                    null, drawable, null);
        }
    }

    /**
     * 设置右边图片
     *
     * @author :Atar
     * @createTime:2014-7-1下午4:33:45
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    protected void setRightImageDrawable(Drawable drawable) {
        if (imgCommonTopRight != null) {
            imgCommonTopRight.setImageDrawable(drawable);
            imgCommonTopRight.setVisibility(View.VISIBLE);
            if (txtCommonTopRight != null) {
                txtCommonTopRight.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 设置顶部右边图片显示or ？？？
     *
     * @param visivility
     * @author :Atar
     * @createTime:2014-11-9下午4:47:52
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    public void setRightVisibility(int visivility) {
        if (imgCommonTopRight != null) {
            imgCommonTopRight.setVisibility(visivility);
        }
    }

    /**
     * 设置顶部右边文字
     *
     * @param strText
     * @author :Atar
     * @createTime:2014-11-13下午1:55:56
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    protected void setTopRightText(String strText) {
        if (txtCommonTopRight != null) {
            txtCommonTopRight.setText(strText);
            txtCommonTopRight.setVisibility(View.VISIBLE);
            if (imgCommonTopRight != null) {
                imgCommonTopRight.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 清除顶部左边点击事件
     *
     * @author :Atar
     * @createTime:2014-7-2下午3:23:57
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:在需要的地方重新设置
     */
    protected void cleanTopLeftClick() {
        commonTopLeftIsBack = false;
    }

    /**
     * 隐藏loading圈
     *
     * @author :Atar
     * @createTime:2014-9-3上午11:33:27
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    public void setLoadingViewGone() {
        if (linearLoading != null) {
            linearLoading.setVisibility(View.GONE);
        }
    }

    /**
     * 显示loading圈
     *
     * @author :Atar
     * @createTime:2014-9-3上午11:39:16
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    public void setLoadingViewVisible(String loadingText) {
        if (linearLoading != null) {
            linearLoading.setVisibility(View.VISIBLE);
            if (txt_loading_notice != null) {
                txt_loading_notice.setText(loadingText);
            }
        }
    }

    /**
     * 设置标题右边文字
     *
     * @param strRightTxt
     * @author :Atar
     * @createTime:2015-6-4下午5:34:46
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    public void setActivityRightTxt(String strRightTxt) {
        if (txtActivityRightTxt != null) {
            txtActivityRightTxt.setText(strRightTxt);
            txtActivityRightTxt.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 隐藏标题右边文字
     *
     * @author :Atar
     * @createTime:2015-6-4下午5:35:01
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    public void setActivityRightTxtGone() {
        if (txtActivityRightTxt != null) {
            txtActivityRightTxt.setVisibility(View.GONE);
        }
    }

    /**
     * 初始化整个activity
     *
     * @author :Atar
     * @createTime:2014-6-13下午9:06:21
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    protected void init() {
        try {
            initControl();
            initDefaultString();
            initValue();
            bindEvent();
        } catch (Exception e) {
            ShowLog.e(TAG, "init()-->" + CrashHandler.crashToString(e));
        }
    }

    /**
     * 装载控件
     *
     * @author :Atar
     * @createTime:2014-6-13上午11:35:38
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description: 如:findViewById(R.id.xxx)
     */
    protected void initControl() {
    }// 装载控件

    /**
     * 绑定监听事件
     *
     * @author :Atar
     * @createTime:2014-6-13上午11:36:31
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description: 如:setOnClickListener(this)等
     */
    protected void bindEvent() {
    }// 绑定监听事件

    /**
     * 设置默认固定文字，如titlebar上标题等，全放在加载资源包里面，可动态修改
     */
    protected void initDefaultString() {

    }

    /**
     * 初始化值:
     *
     * @author :Atar
     * @createTime:2014-6-13上午11:37:53
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description: 如:setText("XXXX")
     */
    protected void initValue() {
    }// 初始化值

    @Override
    public void NetWorkCall(NetWorkMsg msg) {
        setLoadingViewGone();
        // CommonLoading.dissMissLoading();
    }

    @Override
    public void onOpenDrawerComplete() {
        IntentUtil.finishWithOutTween(this);
    }

    @Override
    public boolean onMoveRight() {
        return false;
    }

    /**
     * 是否继承该AtarCommonActivity所有布局
     *
     * @param isExtendsQuanpeitongShopCommonActivity 在super.onCreat() 之前调用
     * @author :Atar
     * @createTime:2014-8-25下午5:05:32
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    public void setIsExtendsQuanpeitongShopCommonActivity(boolean isExtendsQuanpeitongShopCommonActivity) {
        this.isExtendsQQmusicCommonActivity = isExtendsQuanpeitongShopCommonActivity;
    }

    /**
     * android 4.4+上状态栏是否透明
     *
     * @param isFlagTranslucentStatus
     * @author :Atar
     * @createTime:2015-9-2下午1:56:17
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description: 在super.onCreat() 之前调用
     */
    public void setIsFlagTranslucentStatus(boolean isFlagTranslucentStatus) {
        this.isFlagTranslucentStatus = isFlagTranslucentStatus;
    }

    /**
     * 确认退到后台
     *
     * @author :Atar
     * @createTime:2014-7-8下午2:13:03
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    public void runOnBackground() {
        if (linearLoading != null && linearLoading.getVisibility() == View.VISIBLE) {
            setLoadingViewGone();
            return;
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// 注意
            intent.addCategory(Intent.CATEGORY_HOME);
            this.startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        if (linearLoading != null
                && linearLoading.getVisibility() == View.VISIBLE) {
            setLoadingViewGone();
            return;
        }
        super.onBackPressed();
        IntentUtil.finish(this);
    }

    @Override
    public void ChangeSkin(int skinType) {
        if (isExtendsQQmusicCommonActivity) {
            SkinUtils.setImageDrawable(this, R.string.array_drawable_common_img_back_drawable, skinType,
                    imgCommonTopLeft);
            SkinUtils.setBackgroundDrawable(this, R.string.drawable_select_transparent0_to_transparent2_bg, imgCommonTopLeft, txtCommonTopRight, txtCommonTopLeft, imgCommonTopRight);
            SkinUtils.setBackgroundColor(this, R.string.array_color_common_content_bg_color,
                    skinType, commonContentBg);

            SkinUtils.setTextColor(this, R.string.array_color_common_white_color,
                    skinType, txtCommonTopTitle, txtCommonTopRight);
            SkinUtils.setBackgroundColor(this, R.string.array_color_common_toptilebar_bg_color, skinType, topTitleBarBg);
            SkinUtils.setTextColor(this, R.string.array_color_common_white_color, skinType, txt_loading_notice);
//            SkinUtils.setBackgroundColor(this, R.string.color_black, linearLoading);
        }
    }
}
