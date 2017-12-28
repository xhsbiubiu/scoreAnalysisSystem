package com.fwwb.scoreAnalysis.courseScore.model;

/**
 * Created by Administrator on 2017/12/20.
 */
public class ScoreDTO {

    private Long stuId;

    private String stuGender;

    private String stuClassName;

    private Integer scoreCourseScore;

    private int maximum;

    private int minimum;

    private double average;

    private int notPassNumber;

    private int excellentNumber;

    private int goodNumber;

    private int mediumNumber;

    private int passNumber;

    public int getNotPassNumber() {
        return notPassNumber;
    }

    public void setNotPassNumber(int notPassNumber) {
        this.notPassNumber = notPassNumber;
    }

    public int getExcellentNumber() {
        return excellentNumber;
    }

    public void setExcellentNumber(int excellentNumber) {
        this.excellentNumber = excellentNumber;
    }

    public int getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(int goodNumber) {
        this.goodNumber = goodNumber;
    }

    public int getMediumNumber() {
        return mediumNumber;
    }

    public void setMediumNumber(int mediumNumber) {
        this.mediumNumber = mediumNumber;
    }

    public int getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(int passNumber) {
        this.passNumber = passNumber;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public String getStuClassName() {
        return stuClassName;
    }

    public void setStuClassName(String stuClassName) {
        this.stuClassName = stuClassName;
    }

    public Integer getScoreCourseScore() {
        return scoreCourseScore;
    }

    public void setScoreCourseScore(Integer scoreCourseScore) {
        this.scoreCourseScore = scoreCourseScore;
    }
}
