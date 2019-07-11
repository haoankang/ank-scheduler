package ank.hao.core.model;

import java.io.Serializable;

public class ReturnT<T> implements Serializable {

    public static final long serialVersionUID = 42L;

    public static final ReturnT SUCCESS = new ReturnT(200);
    public static final ReturnT FAIL = new ReturnT(400);
    public static final ReturnT TIMEOUT = new ReturnT(405);

    private int code;
    private String message;
    private T content;

    public ReturnT() {
    }

    public ReturnT(int code) {
        this.code = code;
    }

    public ReturnT(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ReturnT(int code, String message, T content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ReturnT{" + "code=" + code + ", message='" + message + '\'' + ", content=" + content + '}';
    }
}
