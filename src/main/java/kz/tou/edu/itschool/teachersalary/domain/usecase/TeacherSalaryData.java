package kz.tou.edu.itschool.teachersalary.domain.usecase;

public record TeacherSalaryData(
        int serialNumber,
        String firstName,
        String lastName,
        String salary
) {}