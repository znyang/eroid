package com.zen.android.center.sdk.base;

/**
 * EvilReference
 *
 * @author zeny
 * @version 2015.10.31
 */
public class EvilReference<T> {

    private  T mData;

    public EvilReference(T data) {
        mData = data;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }
}
