package org.example.controller;

import org.example.entities.Course;
import org.example.model.CourseModel;
import org.example.persistence.ConnectionDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class CourseController {
    CourseModel courseModel;
    public CourseController(){
        this.courseModel=new CourseModel();
    }
    public void createCourse(){
        String nameCourse = JOptionPane.showInputDialog("Ingrese el nombre del curso").toLowerCase(Locale.ROOT);
        //Course course = new Course(0,nameCourse);
        Course result =this.courseModel.createModelCourse(nameCourse);
        //JOptionPane.showMessageDialog(null,result.toString());
    }
    public void deleteCourse(){
        Connection connection = ConnectionDB.openConnection();
        String nameCourse = JOptionPane.showInputDialog("Ingrese el nombre del curso que va eliminar");
        this.courseModel.deleteModelCourse(nameCourse);
    }
    public void readAllCourses(){
        this.courseModel.readAllModelCourse();
    }
}
