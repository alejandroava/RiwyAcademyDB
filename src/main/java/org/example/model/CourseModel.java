package org.example.model;

import org.example.entities.Course;
import org.example.persistence.ConnectionDB;
import org.example.persistence.imodel.IModelCourse;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseModel implements IModelCourse {

    @Override
    public void deleteModelCourse(String nameCourse) {
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement preparedStatement =  null;
        String sqlQuery = "DELETE FROM Courses WHERE name=?;";
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,nameCourse);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                JOptionPane.showMessageDialog(null,"Curso borrado");
            }else{
                JOptionPane.showMessageDialog(null,"No fue posible borrar el curso");
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) ConnectionDB.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<Course> readAllModelCourse() {
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Course> courses = new ArrayList<>();

        String sqlQuery = "SELECT * FROM Courses;";
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Course course = new Course(resultSet.getInt("id"),
                        resultSet.getString("name"));
                courses.add(course);
            }
            JOptionPane.showMessageDialog(null,courses.toString());
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) ConnectionDB.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return courses;
    }

    @Override
    public Course createModelCourse(String nameCourse) {
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement preparedStatement = null;
        String sqlQuery = "INSERT INTO Courses(name) VALUES (?);";
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,nameCourse);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                JOptionPane.showMessageDialog(null,"Curso creado con exito");
            }else {
                JOptionPane.showMessageDialog(null,"Ocurrio un error al crear el curso");
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
