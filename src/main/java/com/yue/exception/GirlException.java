package com.yue.exception;

import com.yue.enums.ResultEnum;

public class GirlException extends RuntimeException{ //spring框架只对RuntimeException异常进行事物回滚

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
