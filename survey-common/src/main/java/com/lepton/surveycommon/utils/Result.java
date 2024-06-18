package com.lepton.surveycommon.utils;


import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *
 */
@Data
@Component
public class Result <T>{

    private int code;

    private String message;

    private T data;

    // response success
    public Result<T> ok(T data){
        this.code = 200;
        this.message = "OK";
        this.data = data;
        return this;
    }

    public Result<T> ok(){
        this.code = 200;
        this.message = "OK";
        return this;
    }

    // response failed
    public Result<T> error(String message, int code){
        this.code = code;
        this.message = message;
        return this;
    }

    public Result<T> error(int code){
        this.code = code;

        return this;

    }

}
