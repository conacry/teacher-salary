package kz.tou.edu.itschool.teachersalary.domain.entity;

import kz.tou.edu.itschool.teachersalary.domain.entity.exception.TeacherIsNullException;
import kz.tou.edu.itschool.teachersalary.domain.entity.exception.WorkDaysIsNullException;
import kz.tou.edu.itschool.teachersalary.testDouble.stub.TeacherStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TeacherSalaryCalculatorTest {

    @Test
    void calcSalary_teacherIsNull_throwException() {
        var salaryCalc = new TeacherSalaryCalculator();
        assertThrows(TeacherIsNullException.class, () -> salaryCalc.calcSalary(null, WorkDays.of(10)));
    }

    @Test
    void calcSalary_workDaysIsNull_throwException() {
        var salaryCalc = new TeacherSalaryCalculator();
        assertThrows(WorkDaysIsNullException.class, () -> salaryCalc.calcSalary(TeacherStub.getTeacher(), null));
    }
}