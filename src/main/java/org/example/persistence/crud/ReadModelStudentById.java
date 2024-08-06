package org.example.persistence.crud;

import java.util.List;

public interface ReadModelStudentById <Entity>{
    public List<Entity> readModelStudentById(int id);
}
