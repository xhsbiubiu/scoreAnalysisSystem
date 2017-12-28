package com.fwwb.scoreAnalysis.courseScoreController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fwwb.scoreAnalysis.common.page.Page;
import com.fwwb.scoreAnalysis.common.response.RestResponse;
import com.fwwb.scoreAnalysis.common.response.RestUtil;
import com.fwwb.scoreAnalysis.courseScore.model.CourseDTO;
import com.fwwb.scoreAnalysis.courseScore.model.Score;
import com.fwwb.scoreAnalysis.courseScore.model.ScoreDTO;
import com.fwwb.scoreAnalysis.courseScore.service.CourseScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * Created by Administrator on 2017/12/20.
 */
@RestController
@RequestMapping("/fwwb")
public class CourseScoreRestController {

    @Autowired
    CourseScoreService courseScoreService;

    @RequestMapping("/courseScore/page")
    public RestResponse getCourseScore(@RequestParam(value = "courseName")String courseName,
                                       @RequestParam(value = "termName")String termName,
                                       @RequestParam(value = "courseType")String courseType,
                                       Page page)throws UnsupportedEncodingException {
        Page<ScoreDTO> scoreDTOPage = courseScoreService.getCourseScore(URLDecoder.decode(courseName,"UTF-8"),URLDecoder.decode(termName,"UTF-8"),URLDecoder.decode(courseType,"UTF-8"),page);
        RestResponse response = RestUtil.getResponse();
        response.setData(scoreDTOPage);
        return response;
    }

    @RequestMapping("/course")
    public RestResponse getCourse(Page page){
        Page<Score> courses = courseScoreService.getCourse(page);
        RestResponse response = RestUtil.getResponse();
        response.setData(courses);
        return response;
    }

    @RequestMapping("/course/bar")
    public RestResponse getCourseInfo(@RequestParam("termName")String termName,
                                      @RequestParam("courseIds")String[] courseIds)throws UnsupportedEncodingException{
        String jsonText = JSONArray.toJSONString(courseIds,true);//字符串数组转成json格式字符串
        List<String> courseIdList = JSON.parseArray(jsonText,String.class);//json字符串转成list
        List<CourseDTO> courseDTOS = courseScoreService.getCourseInfo(courseIdList,URLDecoder.decode(termName,"UTF-8"));
        for(int i = 0;i < courseDTOS.size();i++){
            CourseDTO courseDTO = courseDTOS.get(i);
            courseDTO.calculateDistinction();
            courseDTO.calculateExcellentRate();
            courseDTO.calculateGoodRate();
            courseDTO.calculateMediumRate();
            courseDTO.calculatePassRate();
            courseDTO.calculateNotPassRate();
        }
        RestResponse response = RestUtil.getResponse();
        response.setData(courseDTOS);
        return response;
    }

    @RequestMapping("/courseScore/more")
    public RestResponse getCourseScoreMore(@RequestParam(value = "courseName")String courseName,
                                           @RequestParam(value = "termName")String termName,
                                           @RequestParam(value = "courseType")String courseType)
            throws UnsupportedEncodingException{
        List<ScoreDTO> scoreDTOS = courseScoreService.getCourseScoreMore(URLDecoder.decode(courseName,"UTF-8"),URLDecoder.decode(termName,"UTF-8"),URLDecoder.decode(courseType,"UTF-8"));

        RestResponse response = RestUtil.getResponse();
        response.setData(scoreDTOS);
        return response;
    }
}
