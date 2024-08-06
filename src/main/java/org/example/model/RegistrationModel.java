package org.example.model;

import org.example.entities.Registration;
import org.example.persistence.ConnectionDB;
import org.example.persistence.imodel.IModelRegistration;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationModel implements IModelRegistration {
    @Override
    public Registration createModelRegistration(String nameCourse, String nameStudent) {
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement preparedStatement = null;
        String sqlQuery = "INSERT INTO Registrations(student_id,course_id) VALUES(?,?);";
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,nameStudent);
            preparedStatement.setString(2,nameCourse);
            int rowsAffected= preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                JOptionPane.showMessageDialog(null,"Registro creado");
            }else {
                JOptionPane.showMessageDialog(null,"Registro no creado");
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

    @Override
    public void deleteModelRegistration(int id) {
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement preparedStatement = null;
        String sqlQuery = "DELETE FROM Registrations WHERE id=?;";
        try{
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                JOptionPane.showMessageDialog(null,"Registro eliminado");
            }else {
                JOptionPane.showMessageDialog(null,"Registro no eliminado");
            }
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

    }
}
