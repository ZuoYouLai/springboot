package com.myboot.demo.exception;


import com.myboot.demo.dao.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHandler {
    public static final String ERROR_VIEW="error";

    //判断是否是ajax请求
    public static boolean isAjax(HttpServletRequest httpRequest){
        return (httpRequest.getHeader("X-Requested-With")!= null
                && "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With").toString()));
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest httpRequest,
                               HttpServletResponse response, Exception e) throws Exception{

        e.printStackTrace();
        if(isAjax(httpRequest)){
            return JSONResult.errorException(e.getMessage());
        }else{
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("exception", e);
            modelAndView.addObject("url", httpRequest.getRequestURL());
            modelAndView.setViewName(ERROR_VIEW);
            return modelAndView;
        }

    }

}
