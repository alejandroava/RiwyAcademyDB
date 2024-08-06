package org.example.persistence;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static Connection connection = null;

    public static Connection openConnection (){
        String url="jdbc:mysql://127.0.0.1:3306/RiwiAcademyDB";
        String user="root";
        String password="Rlwl2023.";
        try{
            connection = DriverManager.getConnection(url,user,password);
            JOptionPane.showMessageDialog(null,"Conexion exitosa");
        }catch (SQLException error){
            error.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection(){
        try {
            if(connection != null){
                connection.close();
                JOptionPane.showMessageDialog(null,"Conexion cerrada");
            }
        }catch (SQLException error){
            error.printStackTrace();
        }
    }

}
