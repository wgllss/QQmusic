package com.qq.atar.qqmusic.enums;

/**
 * ****************************************************************************************************************************************************************************
 * 消息枚举类
 *
 * @author :Atar
 * @createTime:2014-6-13上午11:26:56
 * @version:1.0.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: 包含错误消息，和每一个请求的消息
 * ****************************************************************************************************************************************************************************
 */
public class EnumMsgWhat {
    /*
     * 网络错误消息枚举 start ***************************************************************
	 */
    /**
     * 没有找到反射方法
     **/
    public static final int ENotFoundMethods_Msg = 0x1001;
    /**
     * HTTP协议错误
     **/
    public static final int EHttpProtocol_Msg = 0x1002;
    /**
     * HTTPSocket通讯错误
     **/
    public static final int EHttpIO_Msg = 0x1003;
    /**
     * XML解解析错误
     **/
    public static final int EXmlParser_Msg = 0x1004;
    /**
     * XML通讯错误
     **/
    public static final int EXmlIO_Msg = 0x1005;
    /**
     * 没有找到反射类
     **/
    public static final int EClassNotFound_Msg = 0x1006;
    /**
     * 反调指针出错
     **/
    public static final int EIllegalAccess_Msg = 0x1007;
    /**
     * 反射安全出错
     **/
    public static final int ESecurity_Msg = 0x1008;
    /**
     * 手机网络不可用
     **/
    public static final int EMobileNetUseless_Msg = 0x1009;
    /**
     * 连接服务器超时
     **/
    public static final int EConnectTimeout_Msg = 0x1010;
    /**
     * 传入参数有空
     **/
    public static final int EParamHasNull_Msg = 0x1011;
    /**
     * 传入无效的参数
     **/
    public static final int EParamUnInvalid_Msg = 0x1012;
    /**
     * Json解析出错
     **/
    public static final int EJsonParser_Msg = 0x1013;
    /**
     * 未知错误异常
     **/
    public static final int ENotDefine_Msg = 0x1014;
    /**
     * 不显示提示toast 默认值用负数
     **/
    public static final int NetWorkMsg1WhithoutToast = -0x1015;
    /**
     * 显示提示toast 默认值用正数才显示
     **/
    public static final int NetWorkMsg1WhithToast = 0x1016;
    /**
     * 用于多线程，代表哪一个线程 默认值用负数
     **/
    public static final int NetWorkThreadMsg2 = -0x1017;
    /**
     * 服务器异常400
     **/
    public static final int EHttpRequestFail400 = 0x1018;
    /**
     * 服务器异常403 ip被封了
     **/
    public static final int EHttpRequestFail403 = 0x1019;
    /**
     * 服务器异常404
     **/
    public static final int EHttpRequestFail404 = 0x1020;
    /**
     * 服务器异常502
     **/
    public static final int EHttpRequestFail502 = 0x1021;
    /**
     * 服务器异常503
     **/
    public static final int EHttpRequestFail503 = 0x1022;
    /**
     * 服务器异常504
     **/
    public static final int EHttpRequestFail504 = 0x1023;
    /**
     * 服务器异常找不到主机host
     **/
    public static final int EUnknownHost_msg = 0x1024;
    /**
     * 服务器异常找不到主机host
     **/
    public static final int EUnknownService_msg = 0x1025;
    /**
     * 服务器异常找不到主机host
     **/
    public static final int EUnsupportedEncoding_msg = 0x1026;
    /**
     * 服务器异常500
     **/
    public static final int EHttpRequestFail500 = 0x1027;
    /**
     * 默认http请求值
     **/
    public static final int HttpDefaultRequest_Msg = 0x1029;
    /*
     * 网络错误消息枚举 end *********************************************************************
	 */

    /********************** 网络错误信息枚举end*******预留100个 *************************************/

    /**
     * 最小刷新延迟标志
     */
    public static final int REFRESH_MIN_TIME = 0x1200;
    /**
     * 正在刷新标志
     */
    public static final int REFRESHING_VIEW = 0x1201;
    /**
     * 去执行下拉刷新动作标志
     */
    public static final int REFRESH_PULL_DOWN = 0x1202;
    /**
     * 去执行上拉加载更多标志
     */
    public static final int REFRESH_PULL_UP = 0x1203;
    /**
     * 上拉下拉刷新操作
     */
    public static final int REFRESH_HANDLER = 0x1204;
    /**
     * 操作1
     */
    public static final int REFRESH_HANDLER1 = 0x1205;
    /**
     * 操作2
     */
    public static final int REFRESH_HANDLER2 = 0x1206;
    /**
     * 操作3
     */
    public static final int REFRESH_HANDLER3 = 0x1207;
    /**
     * 操作4
     */
    public static final int REFRESH_HANDLER4 = 0x1208;
    /**
     * 加载1
     */
    public static final int REFRESH_LOADING1 = 0x1209;
    /**
     * 加载2
     */
    public static final int REFRESH_LOADING2 = 0x1210;
    /**
     * 刷新中出现网络等问题后处理标志
     */
    public static final int REFRESH_ERROR = 0x1211;
    /**
     * 刷新完成标志处理提示
     */
    public static final int REFRESH_COMPLETE = 0x1212;
    /**
     * 刷新完成标志处理提示1
     */
    public static final int REFRESH_COMPLETE1 = 0x1213;
    /**
     * 刷新完成标志处理提示2
     */
    public static final int REFRESH_COMPLETE2 = 0x1214;
    /**
     * 刷新完成标志处理提示3 http请求响应完成
     */
    public static final int REFRESH_COMPLETE3 = 0x1215;
    /**
     * 正在播放
     */
    public static final int AUDIO_PLAYING = 0x1216;
    /**
     * 播放停止
     */
    public static final int AUDIO_STOP = 0x1217;
    /**
     * 操作5
     */
    public static final int REFRESH_HANDLER5 = 0x1218;
    /**
     * 操作6
     */
    public static final int REFRESH_HANDLER6 = 0x1219;
    /**
     * 操作7
     */
    public static final int REFRESH_HANDLER7 = 0x1220;

    /******************************* 刷新操作end*******预留100个 *********************************************/

    /**
     * 从本地加载
     */
    public static final int LOAD_FROM_SQL = 0x1300;
    /**
     * 从本地加载2
     */
    public static final int LOAD_FROM_SQL1 = 0x1301;
    /**
     * 从本地加载3
     */
    public static final int LOAD_FROM_SQL2 = 0x1302;
    /**
     * 从本地加载4
     */
    public static final int LOAD_FROM_SQL3 = 0x1303;
    /**
     * 从数据库加载完成
     */
    public static final int LOAD_FROM_SQL_COMPLETE = 0x1304;
    /**
     * 从本地加载第二组数据1
     */
    public static final int LOAD_FROM_SQL_COMPLETE_1 = 0x1305;
    /**
     * 从本地加载第二组数据2
     */
    public static final int LOAD_FROM_SQL_COMPLETE_2 = 0x1306;
    /**
     * 从本地加载第二组数据3
     */
    public static final int LOAD_FROM_SQL_COMPLETE_3 = 0x1307;
    /**
     * 转化数据1
     */
    public static final int TRANSLATE_COMPLETE = 0x1308;
    /**
     * 转化数据2
     */
    public static final int TRANSLATE_COMPLETE1 = 0x1309;
    /**
     * 转化数据3
     */
    public static final int TRANSLATE_COMPLETE2 = 0x1310;
    /**
     * 转化数据4
     */
    public static final int TRANSLATE_COMPLETE3 = 0x1311;
    /**
     * 搜索
     */
    public static final int LOAD_FROM_SQL_LIKE = 0x1312;
    /**
     * 搜索1
     */
    public static final int LOAD_FROM_SQL_LIKE1 = 0x1313;
    /**
     * 搜索2
     */
    public static final int LOAD_FROM_SQL_LIKE2 = 0x1314;
    /**
     * 搜索3
     */
    public static final int LOAD_FROM_SQL_LIKE3 = 0x1315;
    /**
     * 搜索
     */
    public static final int LOAD_FROM_SQL_LIKE_COMPLETE = 0x1316;
    /**
     * 搜索1
     */
    public static final int LOAD_FROM_SQL_LIKE_COMPLETE1 = 0x1317;
    /**
     * 搜索2
     */
    public static final int LOAD_FROM_SQL_LIKE_COMPLETE2 = 0x1318;
    /**
     * 搜索3
     */
    public static final int LOAD_FROM_SQL_LIKE_COMPLETE3 = 0x1319;
    /**
     * 操作UI
     */
    public static final int HANDLER_CHANGE_UI = 0x1320;
    /**
     * 操作UI1
     */
    public static final int HANDLER_CHANGE_UI1 = 0x1321;
    /**
     * 操作UI2
     */
    public static final int HANDLER_CHANGE_UI2 = 0x1322;
    /**
     * 操作UI3
     */
    public static final int HANDLER_CHANGE_UI3 = 0x1323;
    /**
     * 操作UI4
     */
    public static final int HANDLER_CHANGE_UI4 = 0x1324;

    /******************************* 操作本地数据库end*******预留100个 *********************************************/

    /******************************* 以下操作网络消息枚举***start *******************************************************/
    public static final int EInterface_RecommendList = 0x20002;


}
