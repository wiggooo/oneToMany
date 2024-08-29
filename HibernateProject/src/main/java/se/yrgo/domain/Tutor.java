package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Tutor {
    private String tutorId;
    private String name;
    private int salary;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany
    @JoinColumn(name="TUTOR_FK")
    private List<Student> students;

    public Tutor(){
    }

    public Tutor(String tutorId, String name, int salary){
        this.tutorId = tutorId;
        this.name = name;
        this.salary = salary;
        this.students = new ArrayList<>();
    }

    public void addStudentToStudents(Student newStudent){
        this.students.add(newStudent);
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(this.students);
    }


    public String getTutorId() {
        return tutorId;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Tutor{" + "tutorId='" + tutorId + '\'' + ", name='" + name + '\'' +  ", salary=" + salary + '}';
    }
}