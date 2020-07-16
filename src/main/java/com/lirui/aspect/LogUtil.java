package com.lirui.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogUtil {

    @Pointcut("execution(* com.lirui.controller.MySpringAopController.*(..))")
    public void myPointCut(){

    }

    @Before(value = "myPointCut()")
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
    //环绕通知
    /*
      通知执行顺序：
            环绕前置-->普通前置-->目标方法执行-->环绕正常结束/出现异常-->环绕后置-->普通后置-->普通返回或者异常。
     */
    @Around(value = "myPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Signature signature = proceedingJoinPoint.getSignature();
        Object[] args = proceedingJoinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("环绕通知start:" + signature.getName() +"方法开始执行，参数为：" + Arrays.asList(args));
            result = proceedingJoinPoint.proceed();
            System.out.println("环绕通知stop:" + signature.getName() + "方法执行结束");
        } catch (Throwable throwable) {
            System.out.println("环绕异常通知" + signature.getName() + "出现异常");
        } finally {
            System.out.println("环绕返回通知" + signature.getName() + "方法返回结果是:" + result);
        }
        return result;

    }
}
