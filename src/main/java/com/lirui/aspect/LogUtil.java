package com.lirui.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogUtil {
    @Before("execution(* com.lirui.controller.MySpringAopController.*(..))")
    public static void start(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() +"方法开始执行：参数是" + Arrays.asList(joinPoint.getArgs()));
    }
    @AfterReturning(value = "execution(* com.lirui.controller.MySpringAopController.*(..))",returning = "result")
    public static void stop(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName() +"方法执行结束，结果是：" + result);
    }
    @AfterThrowing("execution(* com.lirui.controller.MySpringAopController.*(..))")
    public static void logException(){
        System.out.println("方法抛出异常：");
    }
    @After("execution(* com.lirui.controller.MySpringAopController.*(..))")
    public static void logFinally(){
        System.out.println("方法执行结束。。。。。over");

    }
}
