package com.fwwb.scoreAnalysis.courseScore.model;

public class Student {
    private Long stuId;

    private String stuGender;

    private String stuAcademyId;

    private String stuAcademyName;

    private String stuMajorId;

    private String stuMajorName;

    private String stuClassId;

    private String stuClassName;

    private String stuGrade;

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
        this.stuGender = stuGender == null ? null : stuGender.trim();
    }

    public String getStuAcademyId() {
        return stuAcademyId;
    }

    public void setStuAcademyId(String stuAcademyId) {
        this.stuAcademyId = stuAcademyId == null ? null : stuAcademyId.trim();
    }

    public String getStuAcademyName() {
        return stuAcademyName;
    }

    public void setStuAcademyName(String stuAcademyName) {
        this.stuAcademyName = stuAcademyName == null ? null : stuAcademyName.trim();
    }

    public String getStuMajorId() {
        return stuMajorId;
    }

    public void setStuMajorId(String stuMajorId) {
        this.stuMajorId = stuMajorId == null ? null : stuMajorId.trim();
    }

    public String getStuMajorName() {
        return stuMajorName;
    }

    public void setStuMajorName(String stuMajorName) {
        this.stuMajorName = stuMajorName == null ? null : stuMajorName.trim();
    }

    public String getStuClassId() {
        return stuClassId;
    }

    public void setStuClassId(String stuClassId) {
        this.stuClassId = stuClassId == null ? null : stuClassId.trim();
    }

    public String getStuClassName() {
        return stuClassName;
    }

    public void setStuClassName(String stuClassName) {
        this.stuClassName = stuClassName == null ? null : stuClassName.trim();
    }

    public String getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(String stuGrade) {
        this.stuGrade = stuGrade == null ? null : stuGrade.trim();
    }
}