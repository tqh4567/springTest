package com.mooc.mall.aop;


import com.mooc.mall.utils.LogUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

/**
 * 编写自己的切面类
 */
@Aspect
@Component
public class MyAspect {

    @Autowired
    private LogUtils logUtils;
    @Pointcut("execution(* com.mooc.mall.service.BookService.*(..))")
    public void pointCut(){
    }

    @Before(value = "pointCut()")
    public void aspectBefore(JoinPoint joinpoint) {
        String beforeLog=joinpoint.getSignature().getName()+"执行之前@Before.......参数为{"+ Arrays.asList(joinpoint.getArgs())+"}";
        try {
            logUtils.log(beforeLog+"\r\t");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After(value = "pointCut()")
    public void aspectAfter(JoinPoint joinpoint) {

        String afterLog=joinpoint.getSignature().getName()+"方法执行之后@After.......";
        try {
            logUtils.log(afterLog+"\r\t");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @AfterReturning(value = "pointCut()",returning="result")
    public void aspectReturn(JoinPoint joinpoint,Object result) {
        String returnLog=joinpoint.getSignature().getName()+"方法执行返回@AfterReturning.......返回结果为{"+result+"}";
        try {
            logUtils.log(returnLog+"\r\t");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterThrowing(value = "pointCut()",throwing="exception")
    public void aspectException(Exception exception) {
        String exceptionLog="DIV方法执行出现异常@AfterThrowing........异常信息为"+exception.getMessage();
        try {
            logUtils.log(exceptionLog+"\r\t");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Around("pointCut()")
    public Object aspectAround(ProceedingJoinPoint joinpoint) {
        String methodName = joinpoint.getSignature().getName();
        try {
            logUtils.log("Method Name : [" + methodName + "] ---> AOP around start\r\t");
            long startTimeMillis = System.currentTimeMillis();
            //调用 proceed() 方法才会真正的执行实际被代理的方法
            Object result = joinpoint.proceed();
            long execTimeMillis = System.currentTimeMillis() - startTimeMillis;
            logUtils.log("Method Name : [" + methodName + "] ---> AOP method exec time millis : " + execTimeMillis+"\r\t");
            logUtils.log("Method Name : [" + methodName + "] ---> AOP around end , and result is : " + result.toString()+"\r\t");
            return result;
        } catch (Throwable te) {
            throw new RuntimeException(te.getMessage());
        }
    }
}
