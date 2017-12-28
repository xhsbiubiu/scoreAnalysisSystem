/**
 * Created by Administrator on 2017/12/20.
 */
package score;

import com.fwwb.scoreAnalysis.common.page.Page;
import com.fwwb.scoreAnalysis.courseScore.dao.ScoreDAO;
import com.fwwb.scoreAnalysis.courseScore.model.Score;
import com.fwwb.scoreAnalysis.courseScore.model.ScoreDTO;
import com.fwwb.scoreAnalysis.courseScore.service.CourseScoreService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.List;


@ContextConfiguration("classpath:spring-test.xml")
public class CourseScoreTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    CourseScoreService courseScoreService;

    @Autowired
    ScoreDAO scoreDAO;
    @Test
    public void resultTest(){
        Page page = new Page();
        List<ScoreDTO> scores = scoreDAO.getCourseScoreAll("大学数学（1）线性代数","2010-2011第2学期","必",page);
        System.out.println(scores);
    }
    @Test
    public void courseTest(){
        Page page = new Page();
        List<Score> courses = scoreDAO.getAllCourse(page);
        System.out.println(courses.size());
    }
    @Test
    public void courseTest2(){
    }
}

