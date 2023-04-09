package kz.tou.edu.itschool.teachersalary.domain.entity;

import java.util.UUID;

public class Teacher {
    
    private UUID id;
    private Name firstName;
    private Name lastName;
    private Qualification qualification;
    private int experience;
    
    public UUID getId() {
        return id;
    }
    public Name getFirstName() {
        return firstName;
    }
    public Name getLastName() {
        return lastName;
    }
    public Qualification getQualification() {
        return qualification;
    }
    public int getExperience() {
        return experience;
    }
}
