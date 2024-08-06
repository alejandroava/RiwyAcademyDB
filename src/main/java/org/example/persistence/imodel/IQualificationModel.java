package org.example.persistence.imodel;

import org.example.entities.Qualification;
import org.example.persistence.crud.CreateModelQualification;
import org.example.persistence.crud.UpdateModelQualification;

public interface IQualificationModel extends
        CreateModelQualification<Qualification>,
        UpdateModelQualification<Qualification> {
}
