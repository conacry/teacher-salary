package kz.tou.edu.itschool.teachersalary.domain.entity;

import kz.tou.edu.itschool.teachersalary.domain.entity.exception.TeacherIsNullException;
import kz.tou.edu.itschool.teachersalary.domain.entity.exception.WorkDaysIsNullException;

import java.util.Map;

public class TeacherSalaryCalculator {

    private static final int ONE_HOUR_COST = 1000;
    private static final int LOW_TEACHER_BONUS = 1;
    private static final int MEDIUM_TEACHER_BONUS = 2;
    private static final int HIGH_TEACHER_BONUS = 3;

    private static final int TEN_YEARS_BONUS = 2;
    private static final int TWENTY_YEARS_BONUS = 3;

    private final Map<Qualification, SalaryCalculator> salaryCalculators = Map.ofEntries(
            Map.entry(Qualification.LOW, TeacherSalaryCalculator::calcLowTeacherSalary),
            Map.entry(Qualification.MEDIUM, TeacherSalaryCalculator::calcMediumTeacherSalary),
            Map.entry(Qualification.HIGH, TeacherSalaryCalculator::calcHighTeacherSalary));

    private static int calcLowTeacherSalary(Teacher teacher, int workedDays) {
        return LOW_TEACHER_BONUS * ONE_HOUR_COST * workedDays;
    }

    private static int calcMediumTeacherSalary(Teacher teacher, int workedDays) {
        return MEDIUM_TEACHER_BONUS * ONE_HOUR_COST * workedDays;
    }

    private static int calcHighTeacherSalary(Teacher teacher, int workedDays) {
        if (teacher.getExperience().getValue() > 10 && teacher.getExperience().getValue() < 20) {
            return TEN_YEARS_BONUS * HIGH_TEACHER_BONUS * ONE_HOUR_COST * workedDays;
        } else if (teacher.getExperience().getValue() > 20) {
            return TWENTY_YEARS_BONUS * HIGH_TEACHER_BONUS * ONE_HOUR_COST * workedDays;
        } else {
            return HIGH_TEACHER_BONUS * ONE_HOUR_COST * workedDays;
        }
    }

    public int calcSalary(Teacher teacher, WorkDays workedDays) {
        if (teacher == null) {
            throw new TeacherIsNullException();
        }
        if (workedDays == null) {
            throw new WorkDaysIsNullException();
        }
        var calculator = salaryCalculators.get(teacher.getQualification());
        return calculator.calc(teacher, workedDays.getValue());
    }

}
