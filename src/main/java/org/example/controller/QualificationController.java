package org.example.controller;

import org.example.entities.Qualification;
import org.example.model.QualificationModel;

import javax.swing.*;

public class QualificationController {
    QualificationModel qualificationModel;
    public QualificationController(){
        this.qualificationModel = new QualificationModel();
    }
    public void createQualification(){
        int qualification;
        do{
            qualification = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una calificacion de 0-100"));
        }while (qualification < 0 || qualification >100);
        String description = JOptionPane.showInputDialog("Ingrese una descripcion para la calificacion");
        int courseId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del curso"));
        int studentId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del estudiante"));

        Qualification objqualification = new Qualification(0,qualification,description,courseId,studentId);
        Qualification result = this.qualificationModel.createModelQualification(objqualification);
        JOptionPane.showMessageDialog(null,result.toString());
    }
    public void updateQualification(){
        int qualification;
        do{
            qualification = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una calificacion de 0-100"));
        }while (qualification < 0 || qualification >100);
        String description = JOptionPane.showInputDialog("Ingrese una descripcion para la calificacion");
        int courseId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del curso"));
        int studentId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del estudiante"));

        Qualification objqualification = new Qualification(0,qualification,description,courseId,studentId);
        Qualification result = this.qualificationModel.updateModelQualification(objqualification,studentId);
        JOptionPane.showMessageDialog(null,result.toString());
    }
}
