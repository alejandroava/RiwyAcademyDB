package org.example.entities;

public class Course {
    //Atrinutos
    private int id;
    private String name;

    //Constructor
    public Course (){}

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }
    //Getters


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    //ToString

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "}\n";
    }

}
