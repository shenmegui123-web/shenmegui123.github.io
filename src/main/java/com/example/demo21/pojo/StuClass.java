package com.example.demo21.pojo;

public class StuClass {
    private int classId;
    private String className;
    private String department;

    public StuClass(int classId, String className, String department) {
        this.classId = classId;
        this.className = className;
        this.department = department;
    }
    public int getClassId() {
        return classId;
    }
    public void setClassId(int classId) {
        this.classId = classId;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}
