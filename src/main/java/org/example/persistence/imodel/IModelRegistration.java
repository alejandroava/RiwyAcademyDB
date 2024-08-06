package org.example.persistence.imodel;

import org.example.entities.Registration;
import org.example.persistence.crud.CreateModelRegistration;
import org.example.persistence.crud.DeleteModelRegistration;

public interface IModelRegistration extends
        CreateModelRegistration<Registration>,
        DeleteModelRegistration<Registration>{
}
