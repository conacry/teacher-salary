package kz.tou.edu.itschool.teachersalary.domain.entity;

import kz.tou.edu.itschool.teachersalary.domain.entity.exception.NegativeTeacherExperienceValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TeacherExperienceTest {

    @Test
    void of_intExperienceIsNegativeValue_throwException() {
        var negativeExperience = -20;
        assertThrows(NegativeTeacherExperienceValueException.class, () ->TeacherExperience.of(negativeExperience));
    }

    @Test
    void of_intExperienceValueIsValid_TeacherExperienceIsCreated() {
        var validIntExperience = 10;
        var teacherExperience = TeacherExperience.of(validIntExperience);
        assertEquals(validIntExperience, teacherExperience.getValue());
    }
}