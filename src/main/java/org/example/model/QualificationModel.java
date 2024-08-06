package org.example.model;

import org.example.entities.Qualification;
import org.example.persistence.ConnectionDB;
import org.example.persistence.imodel.IQualificationModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QualificationModel implements IQualificationModel {

    @Override
    public Qualification updateModelQualification(Qualification qualificationEntity, int studentId) {
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement preparedStatement = null;
        String sqlQuery = "UPDATE Students SET Qualification=?,description=?,course_id=?,student_id=? WHERE student_id=?;";;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,qualificationEntity.getId());
            preparedStatement.setString(2,qualificationEntity.getDescription());
            preparedStatement.setInt(3,qualificationEntity.getCourseId());
            preparedStatement.setInt(4,qualificationEntity.getStudentId());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                JOptionPane.showMessageDialog(null,"Calificacion creada con exito");
            }else {
                JOptionPane.showMessageDialog(null,"No fue posible crear la calificacion");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return qualificationEntity;
    }

    @Override
    public Qualification createModelQualification(Qualification qualificationEntity) {
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement preparedStatement = null;
        String sqlQuery = "INSERT INTO Qualifications (Qualification,description,course_id,student_id) VALUES(?,?,?,?);";
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,qualificationEntity.getId());
            preparedStatement.setString(2,qualificationEntity.getDescription());
            preparedStatement.setInt(3,qualificationEntity.getCourseId());
            preparedStatement.setInt(4,qualificationEntity.getStudentId());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                JOptionPane.showMessageDialog(null,"Calificacion creada con exito");
            }else {
                JOptionPane.showMessageDialog(null,"No fue posible crear la calificacion");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
