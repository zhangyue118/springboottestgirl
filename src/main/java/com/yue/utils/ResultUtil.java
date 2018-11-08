package com.yue.utils;

import com.yue.bean.Result;

public class ResultUtil {

    public static Result success(Object object){
        Result result=new Result(0,"成功",object);
        return  result;
    }

    public static Result success(){
        return  success(null);
    }

    public static Result error(Integer code,String msg){
        Result result=new Result(code,msg,null);
        return result;
    }
}
