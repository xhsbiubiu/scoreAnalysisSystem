package com.fwwb.scoreAnalysis.indexController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/12/21.
 */
@Controller
@RequestMapping("/fwwb")
public class IndexController {
    @RequestMapping("/login")
    public String login(){
        return "/framework/index";
    }
}
