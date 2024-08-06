package org.example.controller;

import org.example.model.RegistrationModel;

import javax.swing.*;

public class RegistrationController {
    RegistrationModel registrationModel;
    public RegistrationController(){
        this.registrationModel= new RegistrationModel();
    }
    public void createRegistration(){
        String student = (JOptionPane.showInputDialog("Ingrese el nombre del estudiante"));
        String course = (JOptionPane.showInputDialog("Ingrese el nombre del curso"));
        this.registrationModel.createModelRegistration(student,course);
    }
    public void deleteRegistration(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("ingrese el id del registro a eliminar"));
        this.registrationModel.deleteModelRegistration(id);
    }
}
