package com.qq.atar.qqmusic.config;

import java.util.List;

/**
 * Created by Administrator on 2018/1/24 0024.
 */

public class GridMenuJson {
    private int numColumns;//gridview 列数
    private int horizontalSpacing; //gridview 水平间距
    private int verticalSpacing;//竖直间距
    private double percent;//图片占整个格子百分比
    private List<TabMenuItemBean> gridMenuList;

    public int getNumColumns() {
        return numColumns;
    }

    public int getHorizontalSpacing() {
        return horizontalSpacing;
    }

    public int getVerticalSpacing() {
        return verticalSpacing;
    }

    public List<TabMenuItemBean> getGridMenuList() {
        return gridMenuList;
    }

    public double getPercent() {
        return percent;
    }
}
