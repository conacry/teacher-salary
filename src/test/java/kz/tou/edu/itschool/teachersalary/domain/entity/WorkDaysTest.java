package kz.tou.edu.itschool.teachersalary.domain.entity;

import kz.tou.edu.itschool.teachersalary.domain.entity.exception.LargeDaysValueException;
import kz.tou.edu.itschool.teachersalary.domain.entity.exception.NegativeDaysValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkDaysTest {

    @Test
    void of_intDaysIsNegativeValue_throwException() {
        var negativeDays = -20;
        assertThrows(NegativeDaysValueException.class, () ->WorkDays.of(negativeDays));
    }

    @Test
    void of_intDaysIsTooManyValue_throwException() {
        var largeDays = 35;
        assertThrows(LargeDaysValueException.class, () ->WorkDays.of(largeDays));
    }

    @Test
    void of_intDaysIsValid_WorkDaysIsCreated() {
        var validDays = 19;
        var workDays = WorkDays.of(validDays);
        assertEquals(validDays, workDays.getValue());
    }


}