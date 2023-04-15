package kz.tou.edu.itschool.teachersalary.domain.usecase;

import kz.tou.edu.itschool.teachersalary.domain.entity.TeacherSalaryCalculator;
import kz.tou.edu.itschool.teachersalary.domain.entity.WorkDays;

import java.util.ArrayList;
import java.util.List;

public class CalcTeacherSalaryImpl implements CalcTeacherSalary {

    private TeacherRepository teacherRepository;

    public CalcTeacherSalaryImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<TeacherSalaryData> execute(List<TeacherWorkDayData> teacherWorkDayDataList) {
        var teacherSalaries = new ArrayList<TeacherSalaryData>();

        for (TeacherWorkDayData worData : teacherWorkDayDataList) {
            var workDays = WorkDays.of(worData.workDays());

            var teacher = teacherRepository.getTeacherBySerialNumber(worData.serialNumber());

            var salaryCalculator = new TeacherSalaryCalculator();
            var salary = salaryCalculator.calcSalary(teacher, workDays);

            var teacherSalary = new TeacherSalaryData(
                    teacher.getSerialNumber(),
                    teacher.getFirstName().getValue(),
                    teacher.getLastName().getValue(),
                    salary
            );

            teacherSalaries.add(teacherSalary);
        }

        return teacherSalaries;
    }
}
