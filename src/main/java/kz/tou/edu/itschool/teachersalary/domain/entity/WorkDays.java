package kz.tou.edu.itschool.teachersalary.domain.entity;

import kz.tou.edu.itschool.teachersalary.domain.entity.exception.LargeDaysValueException;
import kz.tou.edu.itschool.teachersalary.domain.entity.exception.NegativeDaysValueException;

public class WorkDays {

    private final int value;

    public static WorkDays of(int days) {
        if (days < 0) {
            throw new NegativeDaysValueException();
        }
        if (days > 31) {
            throw new LargeDaysValueException();
        }

        return new WorkDays(days);
    }

    private WorkDays(int days) {
        this.value = days;
    }

    public int getValue() {
        return value;
    }
}
