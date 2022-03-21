package com.study.frame.aopTest;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 切面2 order比较大 后执行
 * @author liaowenhui
 * @date 2022/3/20 21:15
 */
@Component
@Aspect
@Slf4j
@Order(2)
public class AopAspect2 {

    @Pointcut("@annotation(com.study.frame.aopTest.Annotation2)")
    private void pointCutMethod() {
    }


    //声明前置通知
    @Before("pointCutMethod()")
    public void doBefore(JoinPoint point) {
        log.info("AopAspect2:doBefore");
        return;
    }

    //声明后置通知
    @AfterReturning(pointcut = "pointCutMethod()", returning = "returnValue")
    public void doAfterReturning(JoinPoint point, Object returnValue) {
        log.info("AopAspect2:doAfterReturning,方法返回值为:{}", returnValue);
    }

    //声明例外通知
    @AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
    public void doAfterThrowing(Exception e) {
        log.info("AopAspect2:doAfterThrowing");
    }

    //声明最终通知
    @After("pointCutMethod()")
    public void doAfter() {
        log.info("AopAspect2:doAfter");
    }

    //声明环绕通知
    @Around("pointCutMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        log.info("AopAspect2:doAround-1");
        Object obj = pjp.proceed();
        log.info("AopAspect2:doAround-2");
        return obj;
    }
}
