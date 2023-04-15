package kz.tou.edu.itschool.teachersalary.domain.usecase;

import kz.tou.edu.itschool.teachersalary.domain.entity.Teacher;

import java.util.ArrayList;

public interface TeacherRepository {

    void saveTeachers(ArrayList<Teacher> teachers);

    Teacher getTeacherBySerialNumber(int serialNumber);
}
