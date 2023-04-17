package kz.tou.edu.itschool.teachersalary.domain.entity;

import kz.tou.edu.itschool.teachersalary.domain.entity.exception.NegativeTeacherExperienceValueException;

public class TeacherExperience {

    private final int value;

    public static TeacherExperience of(int intExperience) {
        if (intExperience < 0) {
            throw new NegativeTeacherExperienceValueException();
        }

        return new TeacherExperience(intExperience);
    }

    private TeacherExperience(int experience) {
        this.value = experience;
    }

    public int getValue() {
        return value;
    }
}
