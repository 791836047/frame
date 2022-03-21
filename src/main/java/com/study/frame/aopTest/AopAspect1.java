package com.study.frame.aopTest;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面1 order比较小 先执行
 * @author liaowenhui
 * @date 2022/3/20 21:13
 */
@Component
@Aspect
@Slf4j
@Order(1)
public class AopAspect1 {

    @Pointcut("@annotation(com.study.frame.aopTest.Annotation1)")
    private void pointCutMethod() {
    }

    /**
     * 前置通知: 在一个方法执行之前，执行通知。
     * 模拟执行权限检查
     * @param point
     */
    @Before("pointCutMethod()")
    public void doBefore(JoinPoint point) {
        log.info("AopAspect1:doBefore,目标方法为:{},参数为{}",
                point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName(),
                Arrays.toString(point.getArgs()));
        return;
    }

    /**
     * 返回后通知: 在一个方法执行之后，只有在方法成功完成时，才能执行通知。如果抛异常了，那么不会执行通知(可打开测试Controller注释)。
     * @param point
     * @param returnValue
     */
    @AfterReturning(pointcut = "pointCutMethod()", returning = "returnValue")
    public void doAfterReturning(JoinPoint point,Object returnValue) {
        log.info("AopAspect1:doAfterReturning,方法返回值为:{}", returnValue);
    }

    /**
     * 抛出异常后通知: 在一个方法执行之后，只有在方法退出抛出异常时，才能执行通知。
     * @param e
     */
    @AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
    public void doAfterThrowing(Exception e) {
        log.info("AopAspect1:doAfterThrowing");
    }

    /**
     * 后置通知:在一个方法执行之后，不考虑其结果，执行通知。
     */
    @After("pointCutMethod()")
    public void doAfter() {
        log.info("AopAspect1:doAfter");
    }

    /**
     * 环绕通知: 在建议方法调用之前和之后，执行通知。
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("pointCutMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        log.info("AopAspect1:doAround-1");
        Object obj = pjp.proceed();
        log.info("AopAspect1:doAround-2");
        return obj;
    }
}
