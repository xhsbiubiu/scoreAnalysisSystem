package com.fwwb.scoreAnalysis.courseScore.dao;


import com.fwwb.scoreAnalysis.common.page.Page;
import com.fwwb.scoreAnalysis.courseScore.model.Score;
import com.fwwb.scoreAnalysis.courseScore.model.ScoreDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("scoreDAO")
public interface ScoreDAO {

    List<ScoreDTO> getCourseScore(@Param("courseName") String courseName,
                                  @Param("termName") String termName,
                                  @Param("courseType") String courseType);

    List<ScoreDTO> getCourseScoreAll(@Param("courseName") String courseName,
                                     @Param("termName") String termName,
                                     @Param("courseType") String courseType,
                                     @Param("page")Page page);
    List<Score> getAllCourse(Page page);

    List<Score> getCourseInfo(@Param("courseIds")List<String> courseIds,@Param("termName")String termName);
}