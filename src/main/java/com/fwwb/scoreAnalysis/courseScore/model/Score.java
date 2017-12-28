package com.fwwb.scoreAnalysis.courseScore.model;

import org.springframework.stereotype.Component;

@Component
public class Score {
    private Integer scoreId;

    private String scoreStuId;

    private String scoreCourseId;

    private String scoreCourseName;

    private Integer scoreClassNum;

    private Integer scoreTermId;

    private String scoreTermName;

    private Integer scoreYear;

    private Integer scoreTerm;

    private Integer scoreCourseCredit;

    private String scoreCourseType;

    private Integer scoreCourseScore;

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public String getScoreStuId() {
        return scoreStuId;
    }

    public void setScoreStuId(String scoreStuId) {
        this.scoreStuId = scoreStuId == null ? null : scoreStuId.trim();
    }

    public String getScoreCourseId() {
        return scoreCourseId;
    }

    public void setScoreCourseId(String scoreCourseId) {
        this.scoreCourseId = scoreCourseId == null ? null : scoreCourseId.trim();
    }

    public String getScoreCourseName() {
        return scoreCourseName;
    }

    public void setScoreCourseName(String scoreCourseName) {
        this.scoreCourseName = scoreCourseName == null ? null : scoreCourseName.trim();
    }

    public Integer getScoreClassNum() {
        return scoreClassNum;
    }

    public void setScoreClassNum(Integer scoreClassNum) {
        this.scoreClassNum = scoreClassNum;
    }

    public Integer getScoreTermId() {
        return scoreTermId;
    }

    public void setScoreTermId(Integer scoreTermId) {
        this.scoreTermId = scoreTermId;
    }

    public String getScoreTermName() {
        return scoreTermName;
    }

    public void setScoreTermName(String scoreTermName) {
        this.scoreTermName = scoreTermName == null ? null : scoreTermName.trim();
    }

    public Integer getScoreYear() {
        return scoreYear;
    }

    public void setScoreYear(Integer scoreYear) {
        this.scoreYear = scoreYear;
    }

    public Integer getScoreTerm() {
        return scoreTerm;
    }

    public void setScoreTerm(Integer scoreTerm) {
        this.scoreTerm = scoreTerm;
    }

    public Integer getScoreCourseCredit() {
        return scoreCourseCredit;
    }

    public void setScoreCourseCredit(Integer scoreCourseCredit) {
        this.scoreCourseCredit = scoreCourseCredit;
    }

    public String getScoreCourseType() {
        return scoreCourseType;
    }

    public void setScoreCourseType(String scoreCourseType) {
        this.scoreCourseType = scoreCourseType == null ? null : scoreCourseType.trim();
    }

    public Integer getScoreCourseScore() {
        return scoreCourseScore;
    }

    public void setScoreCourseScore(Integer scoreCourseScore) {
        this.scoreCourseScore = scoreCourseScore;
    }
}