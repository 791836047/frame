package com.study.frame.aopTest;


import java.lang.annotation.*;

/**
 * 自定义注解1
 * @author JustJavaIt
 * @date 2022/3/20 21:09
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Annotation1 {

}
