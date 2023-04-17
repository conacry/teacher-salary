package kz.tou.edu.itschool.teachersalary.domain.usecase;

import kz.tou.edu.itschool.teachersalary.domain.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

public interface TeacherRepository {

    void saveTeachers(List<Teacher> teachers);

    Teacher getTeacherBySerialNumber(int serialNumber);
}
