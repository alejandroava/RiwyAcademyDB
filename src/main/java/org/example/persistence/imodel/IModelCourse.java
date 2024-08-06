package org.example.persistence.imodel;

import org.example.entities.Course;
import org.example.persistence.crud.CreateModel;
import org.example.persistence.crud.CreateModelCourse;
import org.example.persistence.crud.DeleteModelCourse;
import org.example.persistence.crud.ReadAllModelCourse;

public interface IModelCourse extends
        CreateModelCourse<Course>,
        DeleteModelCourse<Course>,
        ReadAllModelCourse<Course>{
}
