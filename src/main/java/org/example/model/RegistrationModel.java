package org.example.model;

import org.example.entities.Registration;
import org.example.persistence.ConnectionDB;
import org.example.persistence.imodel.IModelRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegistrationModel implements IModelRegistration {
    @Override
    public Registration createModelRegistration(String nameCourse, String nameStudent) {
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement preparedStatement = null;
        String sqlQuery = "SELECT ";

        return null;
    }

    @Override
    public void deleteModelRegistration(int id) {

    }
}
