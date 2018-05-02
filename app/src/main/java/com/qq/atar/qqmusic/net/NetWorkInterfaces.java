package com.qq.atar.qqmusic.net;

import android.app.Activity;
import android.http.HttpUrlConnectionRequest;
import android.interfaces.NetWorkCallListener;
import android.interfaces.NetWorkCallTListenet;
import android.reflection.NetWorkMsg;
import android.reflection.ThreadPoolTool;

import com.qq.atar.qqmusic.enums.EnumMsgWhat;
import com.qq.atar.qqmusic.moudle.RecommendJson;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * ****************************************************************************************************************************************************************************
 * 网络层异步调用接口
 *
 * @author :Atar
 * @createTime:2014-6-18下午8:55:09
 * @version:1.0.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: 已经实现异步请求
 * ****************************************************************************************************************************************************************************
 */
public class NetWorkInterfaces {
    private static final String TAG = NetWorkInterfaces.class.getSimpleName();

    /**
     * 适用所有请求方法
     *
     * @param activity
     * @param mNetWorkCallTListenet
     * @param url
     * @param method
     * @param map
     * @param typeOfT
     * @author :Atar
     * @createTime:2017-8-10上午10:58:01
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    public static <T> void NetWorkCall(Activity activity, final NetWorkCallTListenet<T> mNetWorkCallTListenet, String url, String method, Map<String, String> map, Type typeOfT) {
        method = "POST".equals(method) ? HttpUrlConnectionRequest.POST : HttpUrlConnectionRequest.GET;
        Object[] params = null;
        if (activity != null) {
            params = new Object[]{url, map, UrlParamCommon.UTF_8, activity};
        } else {
            params = new Object[]{url, map, UrlParamCommon.UTF_8};
        }
        ThreadPoolTool.getInstance().setAsyncTask(EnumMsgWhat.HttpDefaultRequest_Msg, new NetWorkCallListener() {
            @Override
            public void NetWorkCall(NetWorkMsg msg) {
                switch (msg.what) {
                    case EnumMsgWhat.HttpDefaultRequest_Msg:
                        T t = (T) msg.obj;
                        if (mNetWorkCallTListenet != null) {
                            mNetWorkCallTListenet.NetWorkCall(t);
                        }
                        break;
                    default:
                        break;
                }
            }
        }, activity, HttpUrlConnectionRequest.class.getName(), method, params, typeOfT);
    }

    public static void getRecommendList(Activity activity, NetWorkCallListener mNetWorkCallListener) {
        Map<String, String> map = new HashMap<String, String>();
        Object[] params = new Object[]{UrlParamCommon.recommend_url, map, UrlParamCommon.UTF_8, activity};
        ThreadPoolTool.getInstance().setAsyncTask(EnumMsgWhat.EInterface_RecommendList, mNetWorkCallListener, activity, HttpUrlConnectionRequest.class.getName(), HttpUrlConnectionRequest.GET,
                params, RecommendJson.class);
    }
}
