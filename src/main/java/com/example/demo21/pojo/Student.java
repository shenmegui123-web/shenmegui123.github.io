package com.example.demo21.pojo;

public class Student {
    private int id;
    private String stuNo;
    private String stuName;
    private String stuClass;
    private StuClass sClass;

    public Student() {}

    public Student(int id, String stuNo, String stuName, String stuClass) {
        this.id = id;
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuClass = stuClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public void setsClass(StuClass sClass) { this.sClass = sClass; }

    public StuClass getSClass() {
        return sClass;
    }
}
