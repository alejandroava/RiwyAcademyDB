package org.example;

import org.example.controller.CourseController;
import org.example.controller.QualificationController;
import org.example.controller.RegistrationController;
import org.example.controller.StudenController;
import org.example.persistence.ConnectionDB;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudenController studenController = new StudenController();
        CourseController courseController = new CourseController();
        QualificationController qualificationController = new QualificationController();
        RegistrationController registrationController = new RegistrationController();

        Boolean runMenu = true;
        while(runMenu){
            String optionUser= JOptionPane.showInputDialog("Bienvenido a Riwi Academy\n"+
            "1.Estudiantes\n" +
                    "2.Cursos\n"+
                    "3.Calificaciones\n"+
                    "4.Registros\n"+
                    "5.Salir");

            switch (optionUser){
                case "1":
                    String optionMenuStudent = JOptionPane.showInputDialog("1.Crear Estudiante\n"+
                            "2.Editar Estudiante\n"+
                            "3.Mostrar estudiantes activos\n"+
                            "4.Buscar estudiante por ID\n"+
                            "5.Buscar estudiante por email\n"+
                            "6.Salir");
                    if(optionMenuStudent.equals("1")){
                        studenController.create();
                        break;
                    } else if (optionMenuStudent.equals("3")) {
                        studenController.readStudentActive();
                    } else if (optionMenuStudent.equals("2")) {
                        studenController.updateStudent();
                    } else if (optionMenuStudent.equals("4")) {
                        studenController.readStudentById();
                    } else if (optionMenuStudent.equals("5")) {
                        studenController.readStudentByEmail();
                    } else if (optionMenuStudent.equals("6")) {
                            break;
                    } else{
                        JOptionPane.showMessageDialog(null,"ingrese una opcion valida");
                        continue;
                    }
                    break;
                case "2":
                    String optionMenuCourses = JOptionPane.showInputDialog("1.Crear curso\n"+
                            "2.Eliminar curso\n"+
                            "3.Mostrar todos los cursos\n"+
                            "4.Salir");
                    if (optionMenuCourses.equals("1")) {
                        courseController.createCourse();
                    } else if (optionMenuCourses.equals("2")) {
                        courseController.deleteCourse();
                    } else if (optionMenuCourses.equals("3")) {
                        courseController.readAllCourses();
                    }else if(optionMenuCourses.equals("4")) {
                        break;
                    }else {
                        JOptionPane.showMessageDialog(null,"Ingrese una opcion valida");
                        continue;
                    }
                    break;
                case "3":
                    String optionMenuQualification = JOptionPane.showInputDialog("1.Crear calificacion\n"+
                            "2.Editar calificacion\n"+
                            "3.Salir");
                    if (optionMenuQualification.equals("1")) {
                        qualificationController.createQualification();
                    } else if (optionMenuQualification.equals("2")) {
                        qualificationController.updateQualification();
                    }else {
                        break;
                    }
                case "4":
                    String optionMenuRegistration = JOptionPane.showInputDialog("1.Crear inscripcion\n"+
                            "2.Eliminar inscripcion\n"+
                            "3.Salir");
                    if(optionMenuRegistration.equals("1")){
                        registrationController.createRegistration();
                    } else if (optionMenuRegistration.equals("2")) {
                        registrationController.deleteRegistration();
                    }
                    break;
                case "5":
                    runMenu = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Ingrese una opcion valida");
            }

        }
    }
}