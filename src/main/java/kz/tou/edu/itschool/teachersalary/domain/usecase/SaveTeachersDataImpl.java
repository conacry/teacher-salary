package kz.tou.edu.itschool.teachersalary.domain.usecase;

import kz.tou.edu.itschool.teachersalary.domain.entity.Name;
import kz.tou.edu.itschool.teachersalary.domain.entity.Qualification;
import kz.tou.edu.itschool.teachersalary.domain.entity.Teacher;
import kz.tou.edu.itschool.teachersalary.domain.entity.TeacherExperience;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SaveTeachersDataImpl implements SaveTeachersData {

    private final TeacherRepository teacherRepository;

    public SaveTeachersDataImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void execute(List<TeacherData> teacherDataList) {
        var teachers = new ArrayList<Teacher>();

        for (TeacherData teacherData : teacherDataList) {
            var firstName = Name.of(teacherData.firstName());
            var lastName = Name.of(teacherData.lastName());
            var qualification = Qualification.valueOf(teacherData.qualification());
            var experience = TeacherExperience.of(teacherData.experience());

            var teacher = new Teacher.TeacherBuilder().
                    id(UUID.randomUUID()).
                    serialNumber(teacherData.serialNumber()).
                    firstName(firstName).
                    lastName(lastName).
                    qualification(qualification).
                    experience(experience).
                    build();

            teachers.add(teacher);
        }

        teacherRepository.saveTeachers(teachers);
    }
}
