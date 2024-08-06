package org.example.model;

import com.sun.source.tree.TryTree;
import org.example.entities.Student;
import org.example.persistence.ConnectionDB;
import org.example.persistence.imodel.IModelStudent;
import org.example.utils.Status;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModel implements IModelStudent {
    @Override
    public Student create(Student request) {
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement preparedStatement = null;
        String sqlQuery = "INSERT INTO Students(name,lastname,status,email,course_id) VALUES(?,?,?,?,?);";

        try {
            preparedStatement = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, request.getName());
            preparedStatement.setString(2, request.getLastname());
            preparedStatement.setString(3, request.getStatus().name());
            preparedStatement.setString(4, request.getEmail());
            preparedStatement.setInt(5, request.getCourseId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Estudiante creado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se puede crear el estudiante");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) ConnectionDB.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return request;
    }

    @Override
    public List<Student> readModelStudent() {
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> students = new ArrayList<>();

        String sqlQuery = "SELECT * FROM Students WHERE status ='ACTIVE';";
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Status status = Status.valueOf(resultSet.getString("status"));
                Student student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        status,
                        resultSet.getString("email"),
                        resultSet.getInt("course_id"));
                students.add(student);
                JOptionPane.showMessageDialog(null, students.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (resultSet != null) resultSet.close();
                if (connection != null) ConnectionDB.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return students;
    }

    @Override
    public List<Student> readModelStudentById(int id) {
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> students = new ArrayList<>();

        String sqlQuery = "SELECT * FROM Students WHERE id=?;";
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Status status = Status.valueOf(resultSet.getString("status"));
                Student student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        status,
                        resultSet.getString("email"),
                        resultSet.getInt("course_id"));
                students.add(student);
                JOptionPane.showMessageDialog(null, students.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (resultSet != null) resultSet.close();
                if (connection != null) ConnectionDB.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    @Override
    public Student updateModelStudent(Student studentEntity, String email) {
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement preparedStatement = null;
        String sqlQuery = "UPDATE Students SET name=?,lastname=?,status=?,email=?,course_id=? WHERE email=?;";
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, studentEntity.getName());
            preparedStatement.setString(2, studentEntity.getLastname());
            preparedStatement.setString(3, studentEntity.getStatus().name());
            preparedStatement.setString(4, studentEntity.getEmail());
            preparedStatement.setInt(5, studentEntity.getCourseId());
            preparedStatement.setString(6, email);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "El estudiante fue editado con exito");
                JOptionPane.showMessageDialog(null, studentEntity.toString());
            }else {
                JOptionPane.showMessageDialog(null,"El email del estudiante no existe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) ConnectionDB.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return studentEntity;
    }

    @Override
    public List<Student> readModelStudentByEmail(String email) {
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> students = new ArrayList<>();

        String sqlQuery = "SELECT * FROM Students WHERE email=?;";
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Status status = Status.valueOf(resultSet.getString("status"));
                Student student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        status,
                        resultSet.getString("email"),
                        resultSet.getInt("course_id"));
                students.add(student);
                JOptionPane.showMessageDialog(null, students.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (resultSet != null) resultSet.close();
                if (connection != null) ConnectionDB.closeConnection();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }
}
