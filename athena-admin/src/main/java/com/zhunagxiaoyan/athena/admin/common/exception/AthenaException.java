/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */
package com.zhunagxiaoyan.athena.admin.common.exception;

/**
 * 自定义异常
 *
 * @author Mark sunlightcs@gmail.com
 */
public class AthenaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public AthenaException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public AthenaException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public AthenaException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public AthenaException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
