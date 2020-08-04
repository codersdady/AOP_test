package com.wz.demo.controller;

import com.wz.demo.service.myService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/myc")
public class myController {

    @Autowired
    private myService service;

    @GetMapping(value = "/succ/{id}")
    public String succ(@PathVariable String id) throws InterruptedException {
        service.testLog(id);
        return "success";
    }

    @GetMapping(value = "/error/{id}")
    public String error(@PathVariable String id) throws InterruptedException {
        service.testLog(id);
        return "error";
    }
}
