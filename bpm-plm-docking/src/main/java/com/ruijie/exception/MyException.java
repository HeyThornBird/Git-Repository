package com.ruijie.exception;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 * 自定义异常
 */
public class MyException extends Exception{

    public MyException(String message){
        super(message);
    }

    /**
     * 用指定的详细信息和原因构造一个新的异常
     * @param message
     * @param cause
     */
    public MyException(String message, Throwable cause){
        super(message,cause);
    }

}
