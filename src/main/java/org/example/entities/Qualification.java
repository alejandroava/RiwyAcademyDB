package org.example.entities;

public class Qualification {
    private int id;
    private int qualification;
    private String description;
    private int courseId;
    private int studentId;

    public Qualification(){}

    public Qualification(int id, int qualification, String description, int courseId, int studentId) {
        this.id = id;
        this.qualification = qualification;
        this.description = description;
        this.courseId = courseId;
        this.studentId = studentId;
    }

    //Getters

    public int getId() {
        return id;
    }

    public int getQualification() {
        return qualification;
    }

    public String getDescription() {
        return description;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    //ToString

    @Override
    public String toString() {
        return "Qualification{" +
                "id=" + id +
                ", qualification=" + qualification +
                ", description='" + description + '\'' +
                ", courseId=" + courseId +
                ", studentId=" + studentId +
                '}';
    }
}
