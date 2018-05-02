package com.qq.atar.qqmusic.utils;

import android.application.CrashHandler;
import android.os.Build;
import android.utils.ShowLog;

import java.text.DecimalFormat;

/**
 * Created by Atar on 2018/4/24.
 */

public class NumberUtils {

    public static String formatTosepara(long data) {
        String strNum = "";
        try {
            if (data == 0 || data == 0.00) {
                return "0.00";
            }
            DecimalFormat df = new DecimalFormat("#,###");
            if (Math.abs(data) >= 10000000) {
                data = data / 10000;
                if (Math.abs(data) >= 1000000) {
                    data = data / 10000;
                    df = new DecimalFormat("#,###.##");
                    if (Math.abs(data) >= 1000000) {
                        data = data / 10000;
                        if (Math.abs(data) >= 1000000) {
                            data = data / 10000;
                            if (Math.abs(data) >= 1000000) {
                                DecimalFormat formater = new DecimalFormat("#.##E0");
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                                    formater.setMaximumFractionDigits(2);
                                    formater.setMinimumFractionDigits(2);
                                }
                                return formater.format(data * 10E15);
                            }
                            return df.format(data) + "亿亿";
                        }
                        return df.format(data) + "万亿";
                    }
                    return df.format(data) + " 亿";
                }
                return df.format(data) + " 万";
            }
            return df.format(data);
        } catch (Exception e) {
            return "0";
        }
    }
}
