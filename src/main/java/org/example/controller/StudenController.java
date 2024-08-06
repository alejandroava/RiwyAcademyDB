package org.example.controller;

import org.example.entities.Student;
import org.example.model.StudentModel;
import org.example.utils.Status;

import javax.swing.*;

public class StudenController {
    StudentModel studentModel;
    public StudenController(){
        this.studentModel = new StudentModel();
    }
    public void create(){
        Status status = Status.valueOf(Status.ACTIVE.name());
        String name = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
        String lastname= JOptionPane.showInputDialog("Ingrese el apellido del estudiante");
        //String status = Status.ACTIVE.name();
        String email = JOptionPane.showInputDialog("Ingrese el email");
        int course_id=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del curso del estudiante"));

        Student student = new Student(0,name,lastname,status,email,course_id);
        Student result =this.studentModel.create(student);
        JOptionPane.showMessageDialog(null,result.toString());
    }
    public void readStudentActive(){
        this.studentModel.readModelStudent();
    }
    public void updateStudent(){
        Status status = Status.valueOf(Status.ACTIVE.name());
        String email = JOptionPane.showInputDialog("Ingrese el email del estudiante que va editar");
        String name = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
        String lastname= JOptionPane.showInputDialog("Ingrese el apellido del estudiante");
        //String status = Status.ACTIVE.name();

        int course_id=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el curso del estudiante"));

        Student student = new Student(0,name,lastname,status,email,course_id);
        Student result = this.studentModel.updateModelStudent(student,email);
        //JOptionPane.showMessageDialog(null,result.toString());
    }
    public void readStudentById(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del estudiante"));
        this.studentModel.readModelStudentById(id);
    }
    public void readStudentByEmail(){
        String email = JOptionPane.showInputDialog("Ingrese el email del estudiante");
        this.studentModel.readModelStudentByEmail(email);
    }

}
