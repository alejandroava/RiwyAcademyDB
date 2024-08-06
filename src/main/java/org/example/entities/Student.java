package org.example.entities;

import org.example.utils.Status;

public class Student {
    //Atributos

    private int id;
    private String name;
    private String lastname;
    private Status status = Status.ACTIVE;
    private String email;
    private int courseId;

    //Constructor
    public Student(){}

    public Student(int id, String name, String lastname, Status status, String email, int courseId) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.status = status;
        this.email = email;
        this.courseId = courseId;
    }

    //Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Status getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public int getCourseId() {
        return courseId;
    }

    //Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    //Tostring

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", status=" + status +
                ", email='" + email + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
