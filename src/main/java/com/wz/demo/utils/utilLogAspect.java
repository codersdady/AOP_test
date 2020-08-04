package com.wz.demo.utils;


import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.*;

@Component
@Slf4j
@Aspect
public class utilLogAspect {
    @Pointcut("@annotation(com.wz.demo.utils.utilLog)")
    public void pointcut(){
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object o=null;
        long time;

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        utilLog utillog = method.getDeclaredAnnotation(utilLog.class);
        String className = pjp.getTarget().getClass().getName();//类名
        String methodName = method.getName();//方法名
        //入参信息
        Object[] args = pjp.getArgs();
        List<String> list = new ArrayList<>();
        for (Object obj : args) {
            list.add(new Gson().toJson(obj));
        }
        log.info(className+"."+methodName+"，入参："+list.toString()+"，des："+utillog.des()+"，type："+utillog.type());
        
        try {
            long start=System.currentTimeMillis();
            o=pjp.proceed();
            time=System.currentTimeMillis()-start;
            log.info(className+"."+methodName+"，耗时："+time+"ms");
        }catch (Throwable t){
            log.error("异常原因："+t.getCause());
            log.error("异常信息："+t.getMessage());
            log.error("异常类信息："+t.getClass());
        }
        log.info(className+"."+methodName+"，出参："+o);
        return o;
    }
}
