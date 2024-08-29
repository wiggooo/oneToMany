package se.yrgo.domain;

import jakarta.persistence.*;



@Entity
public class Student
{
    private String enrollmentID;
    private String name;
    private Integer numberOfCourses;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Student(){
    }

    public Student(String name, String enrollmentID) {
        this.name = name;
        this.numberOfCourses = 10;
        this.enrollmentID = enrollmentID;
    }

    public int getId() {
        return id;
    }

    public String getEnrollmentID() {
        return enrollmentID;
    }

    public String getName() {
        return name;
    }

    public Integer getNumberOfCourses() {
        return numberOfCourses;
    }

    public void setEnrollmentID(String enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfCourses(Integer numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" + "enrollmentID='" + enrollmentID + '\'' + ", name='" + name + '\'' + ", id=" + id + '}';
    }
}