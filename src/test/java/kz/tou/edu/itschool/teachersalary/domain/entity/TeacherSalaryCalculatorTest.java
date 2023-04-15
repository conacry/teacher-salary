package kz.tou.edu.itschool.teachersalary.domain.entity;

import kz.tou.edu.itschool.teachersalary.domain.entity.exception.TeacherIsNullException;
import kz.tou.edu.itschool.teachersalary.domain.entity.exception.WorkDaysIsNullException;
import kz.tou.edu.itschool.teachersalary.testDouble.stub.TeacherStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertThrows(WorkDaysIsNullException.class, () -> salaryCalc.calcSalary(TeacherStub.getHighQualificationTeacherWith10Years(), null));
    }

    @Test
    void calcSalary_highTeacherQualification_ReturnSalary() {
        var salaryCalc = new TeacherSalaryCalculator();
        var highQualificationTeacher = TeacherStub.getHighQualificationTeacherWith10Years();
        var workDays = WorkDays.of(20);

        var expectedSalary = 60000;

        var actualSalary = salaryCalc.calcSalary(highQualificationTeacher, workDays);
        assertEquals(expectedSalary, actualSalary);
    }

    @Test
    void calcSalary_mediumTeacherQualification_ReturnSalary() {
        var salaryCalc = new TeacherSalaryCalculator();
        var mediumQualificationTeacher = TeacherStub.getMediumQualificationTeacher();
        var workDays = WorkDays.of(20);

        var expectedSalary = 40000;

        var actualSalary = salaryCalc.calcSalary(mediumQualificationTeacher, workDays);
        assertEquals(expectedSalary, actualSalary);
    }

    @Test
    void calcSalary_lowTeacherQualification_ReturnSalary() {
        var salaryCalc = new TeacherSalaryCalculator();
        var lowQualificationTeacher = TeacherStub.getLowQualificationTeacher();
        var workDays = WorkDays.of(20);

        var expectedSalary = 20000;

        var actualSalary = salaryCalc.calcSalary(lowQualificationTeacher, workDays);
        assertEquals(expectedSalary, actualSalary);
    }
}