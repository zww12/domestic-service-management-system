package com.example.hsms.exception;

import com.example.hsms.entity.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/22
 */
@ControllerAdvice
@ResponseBody
public class GlobleExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public R exceptionHandler(HttpServletRequest request,Exception e){
        System.out.println("全局异常");
        return R.error("服务端异常，请联系管理员"+"<br/>"+e.getMessage());

    }

}
