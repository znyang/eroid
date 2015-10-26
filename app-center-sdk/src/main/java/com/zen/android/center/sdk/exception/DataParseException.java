package com.zen.android.center.sdk.exception;

/**
 * DataParseException
 *
 * @author zeny
 * @version 2015.10.26
 */
public class DataParseException extends CenterException{

    public DataParseException() {
    }

    public DataParseException(String detailMessage) {
        super(detailMessage);
    }

    public DataParseException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public DataParseException(Throwable throwable) {
        super(throwable);
    }
}
