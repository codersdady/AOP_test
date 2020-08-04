package com.wz.demo.service;

import com.wz.demo.utils.utilLog;
import jdk.jfr.events.ThrowablesEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Slf4j
public class myService {

    @utilLog(des = "测试无异常",type = utilLog.Type.BIZ)
    public List<String> testLog(String s) throws InterruptedException {
        List<String > list=new ArrayList<>();
        list.add(s);
        list.add("success");
        return list;
    }

    @utilLog
    public List<String> testLog1(String s)  {

        List<String> list=new ArrayList<>();
        list.add(s);
        list.add("error");

        Object o=s;
        long a= (long) o;

        return list;
    }
}
