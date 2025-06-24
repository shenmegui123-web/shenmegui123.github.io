package com.example.demo21.pojo;

public class Teacher {
    private String username;
    private String password;
    private String teachername;
    private String teacherclass;
    private int subject;
    private String subjectName;
    private String className;

    public Teacher() {}

    public Teacher(String username, String password ) {
        this.username = username;
        this.password = password;
    }
    public Teacher(String username, String password , String teachername , String teacherclass ) {
        this.username = username;
        this.password = password;
        this.teachername = teachername;
        this.teacherclass = teacherclass;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTeachername() {
        return teachername;
    }
    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }
    public void setTeacherclass(String teacherclass) {
        this.teacherclass = teacherclass;
    }
    public String getTeacherclass() {
        return teacherclass;
    }
    public int getSubject() {
        return subject;
    }
    public void setSubject(int subject) {
        this.subject = subject;
    }
    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

}
