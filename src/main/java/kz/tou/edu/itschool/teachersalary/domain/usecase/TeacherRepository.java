package kz.tou.edu.itschool.teachersalary.domain.usecase;

import kz.tou.edu.itschool.teachersalary.domain.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository {

    void saveTeachers(List<Teacher> teachers);

    Optional<Teacher> getTeacherBySerialNumber(int serialNumber);
}
