/**
 *
 */
package com.qq.atar.qqmusic.config;

import java.util.List;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :Atar
 * @createTime:2017-5-23下午4:18:01
 * @version:1.0.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: ****************************************************************************************************************************************************************************
 */
public class AppConfigJson {
    private String versionName;// 版本号 和apk 的versionName一样的值
    private boolean isReplace = true;// 如果apk新发版本 这个配置也新发配置.txt文件，为true: 老版本要替换该配置.txt, false :老版本不替换该.txt
    private String skinVersion;// 皮肤版本
    private String replaceMinVersion;// 替换皮肤的最小版本

    private List<String> all_skins; // 所有种类的皮肤
    private String loadImage_Version;// 开机引导图版本， 更新功能但不用升级apk, 又需要更新引导图 就改成比线上版本号大点，否则可不用配置 (改loadImage_Version 必须改versionName版本大点 和 isReplace为true)
    private List<String> loading_images;// 开机引道页图片
    private List<TabMenuItemBean> main_tab_json;//主页下面tab json
    private HtmlsViewPagerJson homeViewPagerJson;//首页上面tab json

    public List<String> getAll_skins() {
        return all_skins;
    }

    public String getVersionName() {
        return versionName;
    }

    public boolean isReplace() {
        return isReplace;
    }

    public String getSkinVersion() {
        return skinVersion;
    }

    public String getReplaceMinVersion() {
        return replaceMinVersion;
    }

    public List<String> getLoading_images() {
        return loading_images;
    }

    public String getLoadImage_Version() {
//        return loadImage_Version == null ? QuanpeitonshopLoadActivity.loadImage_Version : loadImage_Version;
        return loadImage_Version;
    }

    public List<TabMenuItemBean> getMain_tab_json() {
        return main_tab_json;
    }

    public HtmlsViewPagerJson getHomeViewPagerJson() {
        return homeViewPagerJson;
    }

}
