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
        return teacherWorkDayDataList.stream().
                map(this::doTeacherSalaryCalculation).
                toList();
    }

    private TeacherSalaryData doTeacherSalaryCalculation(TeacherWorkDayData workData) {
        var workDays = WorkDays.of(workData.workDays());

        var teacherOpt = teacherRepository.getTeacherBySerialNumber(workData.serialNumber());
        var teacher = teacherOpt.orElseThrow(TeacherNotFoundException::new);

        var salaryCalculator = new TeacherSalaryCalculator();
        var amount = salaryCalculator.calcSalary(teacher, workDays);

        return new TeacherSalaryData(
                teacher.getSerialNumber(),
                teacher.getFirstName().getValue(),
                teacher.getLastName().getValue(),
                amount.toPlainString()
        );
    }
}
