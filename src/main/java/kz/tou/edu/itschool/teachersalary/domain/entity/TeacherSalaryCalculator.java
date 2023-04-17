package kz.tou.edu.itschool.teachersalary.domain.entity;

import kz.tou.edu.itschool.teachersalary.domain.entity.exception.TeacherIsNullException;
import kz.tou.edu.itschool.teachersalary.domain.entity.exception.WorkDaysIsNullException;

import java.math.BigDecimal;
import java.util.Map;

public class TeacherSalaryCalculator {

    private static final BigDecimal ONE_HOUR_COST = BigDecimal.valueOf(1000);
    private static final BigDecimal LOW_TEACHER_BONUS = BigDecimal.valueOf(1);
    private static final BigDecimal MEDIUM_TEACHER_BONUS = BigDecimal.valueOf(2);
    private static final BigDecimal HIGH_TEACHER_BONUS = BigDecimal.valueOf(3);

    private static final BigDecimal TEN_YEARS_BONUS = BigDecimal.valueOf(2);
    private static final BigDecimal TWENTY_YEARS_BONUS = BigDecimal.valueOf(3);

    private final Map<Qualification, SalaryCalculator> salaryCalculators = Map.ofEntries(
            Map.entry(Qualification.LOW, TeacherSalaryCalculator::calcLowTeacherSalary),
            Map.entry(Qualification.MEDIUM, TeacherSalaryCalculator::calcMediumTeacherSalary),
            Map.entry(Qualification.HIGH, TeacherSalaryCalculator::calcHighTeacherSalary));

    private static BigDecimal calcLowTeacherSalary(Teacher teacher, int workedDays) {
        return LOW_TEACHER_BONUS.
                multiply(ONE_HOUR_COST).
                multiply(BigDecimal.valueOf(workedDays));
    }

    private static BigDecimal calcMediumTeacherSalary(Teacher teacher, int workedDays) {
        return MEDIUM_TEACHER_BONUS.multiply(ONE_HOUR_COST).multiply(BigDecimal.valueOf(workedDays));
    }

    private static BigDecimal calcHighTeacherSalary(Teacher teacher, int workedDays) {
        if (teacher.getExperience().getValue() > 10 && teacher.getExperience().getValue() < 20) {
            return TEN_YEARS_BONUS.multiply(HIGH_TEACHER_BONUS).multiply(BigDecimal.valueOf(workedDays));
        } else if (teacher.getExperience().getValue() > 20) {
            return TWENTY_YEARS_BONUS.multiply(HIGH_TEACHER_BONUS).multiply(BigDecimal.valueOf(workedDays));
        } else {
            return HIGH_TEACHER_BONUS.multiply(ONE_HOUR_COST).multiply(BigDecimal.valueOf(workedDays));
        }
    }

    public BigDecimal calcSalary(Teacher teacher, WorkDays workedDays) {
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
