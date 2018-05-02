package com.qq.atar.qqmusic.moudle;

/**
 * Created by Atar on 2018/4/24.
 */

public class CommonResult<T> {
    private int code;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
