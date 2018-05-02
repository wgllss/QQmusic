/**
 *
 */
package com.qq.atar.qqmusic.globe;

import android.annotation.SuppressLint;
import android.http.HttpRequest;
import android.os.Environment;

/**
 * *****************************************************************************************
 * 自定义全局变量，系统配置静态属性
 *
 * @author: Atar
 * @createTime:2014年7月20日下午5:08:15
 * @modifyTime:
 * @version: 1.0.0
 * @description: 理论上不同的表flag值其实可以相同，本类没这么做
 * *****************************************************************************************
 */
@SuppressLint("SdCardPath")
public class GlobeSettings {
    // 每页显示21/7=3行
    public static final int everyPageGridViewCount = 28; // 每页Gridview显示的数量
    public static final int everyPageGridViewNumColumns = 7; // 每页Gridview显示的列数
    /*************************************************************************************************************************************************/
    /* 拍照后保存图片 */
    public static final String IMG_CAPTURE_PATH = Environment.getExternalStorageDirectory() + "/quanpeitong/photo/";
    /* 保存图片 */
    public static final String IMG_SAVE_PATH = Environment.getExternalStorageDirectory() + "/quanpeitong/image/";
    /**
     * 最小刷新动作时间
     */
    public static final int REFRESH_MIN_TIME = 2000;
    /**
     * 最大刷新时间
     */
    public final static int REFRESH_MAX_TIME = HttpRequest.connectTimeOut + REFRESH_MIN_TIME;

    // 加载头像圆角度数
    public static final int LOAD_IMG_ROUNDE = 100;

    public static final String CURRENT_SELECT_MODE_KEY = "CURRENT_SELECT_MODE_KEY";
    public static final String REMAINING_COUNT_KEY = "REMAINING_COUNT_KEY";
    public static final String UPLOAD_LOACL_FILE_PATH_KEY = "UPLOAD_LOACL_FILE_PATH_KEY";
    public static final String UPLOAD_IMAGE_SESSTION_PATH = Environment.getExternalStorageDirectory() + "/quanpeitong/sesstion/";

    public static final int request_code_select_pic = 1007;
    public static final int request_code_record = 1008;
    public static final int request_code_at_user = 1009;
    public static final int request_code_select_pic2 = 1010;

    /**
     * 本地总文件夹
     */
    public static final String appCommonDir = "quanpeitong";

    /**
     * 本地语音文件目录
     */
    public static final String audioDir = appCommonDir + "/audio/";

    public static final int defaultImage_ResID = 0;

    public static final String interface_app_key = "972C4FCC-2672-49CA-9013-FDB0F9150C7E";
}
