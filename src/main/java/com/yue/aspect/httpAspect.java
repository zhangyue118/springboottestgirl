package com.yue.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * AOP
 */

@Aspect
@Component
public class httpAspect {

    private final static Logger logger= LoggerFactory.getLogger(httpAspect.class);

    @Pointcut("execution(public * com.yue.controller.GirlController.*(..))")
    public void log(){

        //System.out.println("2333333");
    }

    @After("log()")
    public void doAfter(){
        logger.info("666666");
        //System.out.println("666666");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());

        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //参数
        logger.info("args={}",joinPoint.getArgs());

        logger.info("2333333");
        //System.out.println("233333");
    }

    @AfterReturning(pointcut = "log()",returning = "object")
    public void  doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
