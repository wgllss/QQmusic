package com.qq.atar.qqmusic.application;

import android.annotation.TargetApi;
import android.app.Application;
import android.application.CommonApplication;
import android.application.CrashHandler;
import android.content.Context;
import android.interfaces.CommonNetWorkExceptionToast;
import android.os.Build;
import android.skin.SkinResourcesManager;
import android.support.multidex.MultiDex;
import android.utils.ShowLog;

import com.lidroid.xutils.DbUtils;
import com.qq.atar.qqmusic.R;
import com.qq.atar.qqmusic.net.UrlParamCommon;

/**
 * Created by Atar on 2018/4/24.
 */

public class QQmusicApplication extends Application {

    public static QQmusicApplication mInstance;
    private DbUtils db;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        CommonApplication.initApplication(this);// 初始化全局Context
        CommonNetWorkExceptionToast.initToastError(this, R.array.err_toast_string);// 初始化全局网络错误提示信息
        ShowLog.setDebug(true);// 设置不显示日志 上线前记得改成false
        CommonNetWorkExceptionToast.setIsShowErrorToast(true);// 上线前记得设置不显示错误网络具体提示 测试时可开启
        CommonApplication.initImageLoader(getApplicationContext());// 初始化加载图片配置
        // CommonToast.initToastResouseId(R.drawable.corners_toast, R.color.black);// 初始化toast字体颜色和背景
        CrashHandler.getInstance().init(this);// 接收错误异常
        SkinResourcesManager.getInstance(this).initSkinResources(false, "com.example.android_qqmusic_skin", UrlParamCommon.download_skin_url);
        db = getDb();
    }

    public static QQmusicApplication getApplication() {
        return mInstance;
    }

    public DbUtils getDb() {
        if (db == null) {
            db = DbUtils.create(this);
            db.configAllowTransaction(true);
            db.configDebug(false);
        }
        return db;
    }
}
