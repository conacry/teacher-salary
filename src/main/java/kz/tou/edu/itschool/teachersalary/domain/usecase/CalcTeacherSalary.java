package kz.tou.edu.itschool.teachersalary.domain.usecase;

import java.util.List;

public interface CalcTeacherSalary {
    List<TeacherSalaryData> execute(List<TeacherWorkDayData> teacherWorkDayDataList);
}
