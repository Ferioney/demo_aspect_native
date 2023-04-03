package com.example.demo.logic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class HomeAspect {

    Logger logger = LoggerFactory.getLogger(HomeAspect.class);

    @Pointcut("@annotation(com.example.demo.logic.AspectAnnotation)")
    public void point() {}

    @Around("point()")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.debug("Proceed aspect");
        var welcome = proceedingJoinPoint.proceed();
        return "From aspect: " + welcome;
    }
}
