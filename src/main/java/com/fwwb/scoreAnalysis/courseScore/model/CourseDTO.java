package com.fwwb.scoreAnalysis.courseScore.model;

/**
 * Created by Administrator on 2017/12/21.
 */
public class CourseDTO {

    public CourseDTO(){
        notPassNumber = 0;
        excellentNumber = 0;
        goodNumber = 0;
        mediumNumber = 0;
        passNumber = 0;
        total = 0;
    }

    private int total;

    private double notPassRate;

    private double excellentRate;

    private double goodRate;

    private double mediumRate;

    private double passRate;

    private String scoreCourseName;

    private String scoreCourseId;

    private int notPassNumber;

    private int excellentNumber;

    private int goodNumber;

    private int mediumNumber;

    private int passNumber;

    private double  distinction;

    public void calculateDistinction(){
        if(total > 0){
            distinction = ((double) excellentNumber - (double)notPassNumber)/(double)total;
        }
    }

    public void calculateNotPassRate(){
        if(total > 0){
            notPassRate = 100*notPassNumber/total;
        }
    }

    public void calculatePassRate(){
        if(total > 0){
            passRate = 100*passNumber/total;
        }
    }

    public void calculateMediumRate(){
        if(total > 0){
            mediumRate = 100*mediumNumber/total;
        }
    }

    public void calculateGoodRate(){
        if(total > 0){
            goodRate = 100*goodNumber/total;
        }
    }

    public void calculateExcellentRate(){
        if(total > 0){
            excellentRate = 100*excellentNumber/total;
        }
    }

    public void totalAdd(){
        total++;
    }

    public void notPassNumberAdd(){
        notPassNumber++;
    }

    public void excellentNumber(){
        excellentNumber++;
    }

    public void goodNumber(){
        goodNumber++;
    }

    public void mediumNumber(){
        mediumNumber++;
    }

    public void passNumber(){
        notPassNumber++;
    }


    public String getScoreCourseName() {
        return scoreCourseName;
    }

    public void setScoreCourseName(String scoreCourseName) {
        this.scoreCourseName = scoreCourseName;
    }

    public String getScoreCourseId() {
        return scoreCourseId;
    }

    public void setScoreCourseId(String scoreCourseId) {
        this.scoreCourseId = scoreCourseId;
    }

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getNotPassRate() {
        return notPassRate;
    }

    public void setNotPassRate(double notPassRate) {
        this.notPassRate = notPassRate;
    }

    public double getExcellentRate() {
        return excellentRate;
    }

    public void setExcellentRate(double excellentRate) {
        this.excellentRate = excellentRate;
    }

    public double getGoodRate() {
        return goodRate;
    }

    public void setGoodRate(double goodRate) {
        this.goodRate = goodRate;
    }

    public double getMediumRate() {
        return mediumRate;
    }

    public void setMediumRate(double mediumRate) {
        this.mediumRate = mediumRate;
    }

    public double getPassRate() {
        return passRate;
    }

    public void setPassRate(double passRate) {
        this.passRate = passRate;
    }

    public double getDistinction() {
        return distinction;
    }

    public void setDistinction(double distinction) {
        this.distinction = distinction;
    }
}
