/**
 *
 */
package com.qq.atar.qqmusic.interfaces;

import android.view.View;


import com.qq.atar.qqmusic.beans.PopWindowItemBean;

import java.util.List;

/**
 * ****************************************************************************************************************************************************************************
 * 酷炫，动态，我的说说 等页面顶部含有下拉选项 事件 包括中间下拉 或者右边下拉
 *
 * @author :Atar
 * @createTime:2014-7-2上午11:24:20
 * @version:1.0.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: ****************************************************************************************************************************************************************************
 */
public interface OnDropDownListener {

    /**
     * 中间下拉出列表事件
     *
     * @param v
     * @author :Atar
     * @createTime:2014-7-2上午11:48:31
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    void OnDropDownCenter(View v);

    /**
     * 点击中间下拉列表事件
     *
     * @param position 下拉listView的position
     * @param list     下拉ListView数据: 类型为List<DropDownTitleBean>
     * @author :Atar
     * @createTime:2014-7-2上午11:48:55
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    void OnClickCenterDropDownItem(int position, List<PopWindowItemBean> list);

    /**
     * 右边下拉出列表事件
     *
     * @param v
     * @author :Atar
     * @createTime:2014-7-2上午11:48:31
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    void OnDropDownRight(View v);

    /**
     * 点击右边下拉列表事件
     *
     * @param position 下拉listView的position
     * @param list     下拉ListView数据: 类型为List<DropDownTitleBean>
     * @author :Atar
     * @createTime:2014-7-2上午11:48:55
     * @version:1.0.0
     * @modifyTime:
     * @modifyAuthor:
     * @description:
     */
    void OnClickRightDropDownItem(int position, List<PopWindowItemBean> list);
}
