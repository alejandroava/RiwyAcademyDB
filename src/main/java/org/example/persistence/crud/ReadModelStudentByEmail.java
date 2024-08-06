package org.example.persistence.crud;

import java.util.List;

public interface ReadModelStudentByEmail <Entity>{
    public List<Entity> readModelStudentByEmail(String email);
}
