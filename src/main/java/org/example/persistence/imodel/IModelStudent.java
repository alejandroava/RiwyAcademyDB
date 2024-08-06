package org.example.persistence.imodel;

import org.example.entities.Student;
import org.example.persistence.crud.*;

public interface IModelStudent extends
        CreateModel<Student>,
        ReadModelStudentById<Student>,
        ReadAllModelStudent<Student>,
        UpdateModelStudent<Student>,
        ReadModelStudentByEmail<Student> {
}
