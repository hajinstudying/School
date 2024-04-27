package com.javalab.sec02.school;

//교수 클래스
public class Professor {

    //필드
    private String id;      //교수 id
    private String jumin;   //교수 주민번호
    private String name;    //교수 이름
    private int department; //교수 학과코드
    private String grade;   //직급
    private String hiredate;    //입사년도

    //기본생성자
    public Professor() {}

    //오버로딩 생성자
    public Professor(String id, String jumin, String name, int department, String grade, String hiredate) {
        this.id = id;
        this.jumin = jumin;
        this.name = name;
        this.department = department;
        this.grade = grade;
        this.hiredate = hiredate;
    }

    //getter/setter 메소드
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getJumin() {
        return jumin;
    }
    public void setJumin(String jumin) {
        this.jumin = jumin;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDepartment() {
        return department;
    }
    public void setDepartment(int department) {
        this.department = department;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getHiredate() {
        return hiredate;
    }
    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Professor [id=" + id + ", name=" + name + ", department=" + department + ", grade="
                + grade + ", hiredate=" + hiredate + "]";
    }



}