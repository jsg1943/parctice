package com.coderzh.parctice.myAnnotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 注解实现
 * Created by zhangwenbin on 2018/5/10.
 */
@Component
@Aspect
public class MyAnnotationAspect {

    @Around("@annotation(myAnnotation)")
    private void around(ProceedingJoinPoint pjp, MyAnnotation myAnnotation){

        System.out.println("MyAnnotationAspect around start...");
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("MyAnnotationAspect around end...");

    }

//    @Before("com.coderzh.parctice.myAnnotation.test()")
    private void before(){
        System.out.println("MyAnnotationAspect before dosomething...");
    }

}
