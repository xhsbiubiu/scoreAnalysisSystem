package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/12/19.
 */
@Controller
@RequestMapping("/fwwb")
public class HelloController {
    @RequestMapping("/hello")
    public String test(){
        return "framework/courseScore";
    }
}
