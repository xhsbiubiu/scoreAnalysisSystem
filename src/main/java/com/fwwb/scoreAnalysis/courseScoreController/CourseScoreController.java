package com.fwwb.scoreAnalysis.courseScoreController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/12/20.
 */
@Controller
@RequestMapping("/test")
public class CourseScoreController {
    @RequestMapping("/courseScore/view")
    public String view(){
        return "framework/courseScore";
    }
    @RequestMapping("/courseAndCourse/view")
    public String courseView(){
        return "framework/courseAnalysis";
    }
}
