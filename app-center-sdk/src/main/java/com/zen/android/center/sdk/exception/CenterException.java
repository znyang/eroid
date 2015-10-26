package com.zen.android.center.sdk.exception;

/**
 * CenterException
 *
 * @author zeny
 * @version 2015.10.26
 */
public class CenterException extends Exception {

    public CenterException() {
    }

    public CenterException(String detailMessage) {
        super(detailMessage);
    }

    public CenterException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public CenterException(Throwable throwable) {
        super(throwable);
    }
}
