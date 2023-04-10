package kz.tou.edu.itschool.teachersalary.testDouble.stub;

import kz.tou.edu.itschool.teachersalary.domain.entity.Name;
import kz.tou.edu.itschool.teachersalary.domain.entity.Qualification;
import kz.tou.edu.itschool.teachersalary.domain.entity.Teacher;

import java.util.UUID;

public class TeacherStub {

    public static Teacher getTeacher() {
        return new Teacher.TeacherBuilder().
                UUID(UUID.randomUUID()).
                firstName(new Name("firstName")).
                lastName(new Name("lastName")).
                qualification(Qualification.HIGH).
                experience(10).
                build();
    }
}
