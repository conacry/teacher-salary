package kz.tou.edu.itschool.teachersalary.domain.usecase;

public record TeacherData(
        int serialNumber,
        String firstName,
        String lastName,
        String qualification,
        int experience
) {}
