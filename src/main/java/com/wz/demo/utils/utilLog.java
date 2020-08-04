package com.wz.demo.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface utilLog {
    String des() default "";

    Type type() default Type.TMP;

    enum Type{
        /*
        业务方法
         */
        BIZ,

        /*
        数据库连接
         */
        DATA,

        /*
        消息队列
         */
        MQ,

        /*
        临时
         */
        TMP;
        Type(){
        }
    }
}
