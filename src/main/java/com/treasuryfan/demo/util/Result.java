package com.treasuryfan.demo.util;

public class Result {
    private Integer conde;
    private String message;
    private Object data="null";

    public Result(ResponseCode ok, String newTicket, long userid, String username) {
    }

    public Result(Integer conde, String message) {
        this.conde = conde;
        this.message = message;
    }

    public Result(ResponseCode conde, String message, Object data) {
        this.conde = conde.getCode();
        this.message = message;
        this.data = data;
    }

    public Result(ResponseCode responseCode){
        this.conde=responseCode.getCode();
        this.message=responseCode.getMessage();
    }

    public Result(ResponseCode responseCode, Object data){
        this.conde=responseCode.getCode();
        this.message=responseCode.getMessage();
        this.data=data;
    }


    public Integer getConde() {
        return conde;
    }

    public void setConde(Integer conde) {
        this.conde = conde;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + conde +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
