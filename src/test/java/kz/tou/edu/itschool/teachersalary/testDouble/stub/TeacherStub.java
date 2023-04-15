package kz.tou.edu.itschool.teachersalary.testDouble.stub;

import kz.tou.edu.itschool.teachersalary.domain.entity.Name;
import kz.tou.edu.itschool.teachersalary.domain.entity.Qualification;
import kz.tou.edu.itschool.teachersalary.domain.entity.Teacher;

import java.util.UUID;

public class TeacherStub {

    public static Teacher getHighQualificationTeacherWith10Years() {
        return new Teacher.TeacherBuilder().
                UUID(UUID.randomUUID()).
                firstName(Name.of("firstName")).
                lastName(Name.of("lastName")).
                qualification(Qualification.HIGH).
                experience(10).
                build();
    }

    public static Teacher getMediumQualificationTeacher() {
        return new Teacher.TeacherBuilder().
                UUID(UUID.randomUUID()).
                firstName(Name.of("firstName")).
                lastName(Name.of("lastName")).
                qualification(Qualification.MEDIUM).
                experience(10).
                build();
    }

    public static Teacher getLowQualificationTeacher() {
        return new Teacher.TeacherBuilder().
                UUID(UUID.randomUUID()).
                firstName(Name.of("firstName")).
                lastName(Name.of("lastName")).
                qualification(Qualification.LOW).
                experience(10).
                build();
    }
}
