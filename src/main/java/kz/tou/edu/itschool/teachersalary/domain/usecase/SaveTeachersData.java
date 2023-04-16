package kz.tou.edu.itschool.teachersalary.domain.usecase;

import kz.tou.edu.itschool.teachersalary.domain.entity.Teacher;

import java.util.List;

public interface SaveTeachersData {
    void execute(List<TeacherData> teacherDataList);
}
