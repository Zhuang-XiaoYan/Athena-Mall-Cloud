package com.zhuangxiaoyan.athena.code.exception;

import lombok.Data;

/**
 * @description 自定义异常
 * @date: 2022/7/30 8:42
 * @author: xjl
*/

@Data
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
}
