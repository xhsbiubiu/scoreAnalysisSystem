package com.fwwb.scoreAnalysis.courseScore.service;

import com.fwwb.scoreAnalysis.common.page.Page;
import com.fwwb.scoreAnalysis.courseScore.dao.ScoreDAO;
import com.fwwb.scoreAnalysis.courseScore.model.CourseDTO;
import com.fwwb.scoreAnalysis.courseScore.model.Score;
import com.fwwb.scoreAnalysis.courseScore.model.ScoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/12/20.
 */
@Service("courseScoreService")
public class CourseScoreService {

    @Autowired
    ScoreDAO scoreDAO;

    public Page<ScoreDTO> getCourseScore(String courseName, String termName, String courseType, Page page){
        int totalScore = 0;
        List<ScoreDTO> scores = scoreDAO.getCourseScoreAll(courseName,termName,courseType,page);
        for(int i = 0;i < scores.size();i++){
            totalScore += scores.get(i).getScoreCourseScore();
            scores.get(i).setMaximum(scores.get(0).getScoreCourseScore());
            scores.get(i).setMinimum(scores.get(scores.size()-1).getScoreCourseScore());
        }
        for(int i = 0;i < scores.size();i++){
            scores.get(i).setAverage(totalScore/scores.size());
        }
        page.setEntities(scores);
        return page;
    }

    public List<ScoreDTO> getCourseScoreMore(String courseName, String termName, String courseType){
        int totalScore = 0;
        int notPassNumber = 0;
        int excellentNumber = 0;
        int goodNumber = 0;
        int mediumNumber = 0;
        int passNumber = 0;
        List<ScoreDTO> scores = scoreDAO.getCourseScore(courseName,termName,courseType);
        for(int i = 0;i < scores.size();i++){
            int score = scores.get(i).getScoreCourseScore();
            if(score < 60){
                notPassNumber++;
            }else if(score >= 60 && score <= 65){
                passNumber++;
            }else if(score >= 66 && score <= 74){
                mediumNumber++;
            }else if(score >= 75 && score <= 84){
                goodNumber++;
            }else if(score >= 85){
                excellentNumber++;
            }
            totalScore += scores.get(i).getScoreCourseScore();
            scores.get(i).setMaximum(scores.get(0).getScoreCourseScore());
            scores.get(i).setMinimum(scores.get(scores.size()-1).getScoreCourseScore());
        }
        scores.get(0).setExcellentNumber(excellentNumber);
        scores.get(0).setMediumNumber(mediumNumber);
        scores.get(0).setNotPassNumber(notPassNumber);
        scores.get(0).setPassNumber(passNumber);
        scores.get(0).setGoodNumber(goodNumber);
        for(int i = 0;i < scores.size();i++){
            scores.get(i).setAverage(totalScore/scores.size());
        }
        return scores;
    }

    public Page<Score> getCourse(Page page){
        List<Score> courses = scoreDAO.getAllCourse(page);
        page.setEntities(courses);
        return page;
    }

    public List<CourseDTO> getCourseInfo(List courseIds,String termName){

        List<Score> scores = scoreDAO.getCourseInfo(courseIds,termName);
        System.out.println(scores.size());
        List<CourseDTO> courseInfos = new ArrayList<>();
        for(int i = 0; i < courseIds.size();i++){
            String courseId = (String)courseIds.get(i);
            CourseDTO course = new CourseDTO();
            Iterator<Score> it = scores.iterator();
            while (it.hasNext()){
                Score score = it.next();
                if(score.getScoreCourseId().equals(courseId)){
                    course.setScoreCourseId(courseId);
                    course.setScoreCourseName(score.getScoreCourseName());
                    course.totalAdd();
                    int num = score.getScoreCourseScore();
                    if(num < 60){
                        course.notPassNumberAdd();
                    }else if(num >= 60 && num <= 65){
                        course.passNumber();
                    }else if(num >= 66 && num <= 74){
                        course.mediumNumber();
                    }else if(num >= 75 && num <= 84){
                        course.goodNumber();
                    }else if(num >= 85){
                        course.excellentNumber();
                    }
                    it.remove();
                }else {
                    continue;
                }
            }
            if(course.getTotal() > 0)
                courseInfos.add(course);
        }
        return courseInfos;
    }

}
