package kz.tou.edu.itschool.teachersalary.adapter.repository;

import kz.tou.edu.itschool.teachersalary.domain.entity.Teacher;
import kz.tou.edu.itschool.teachersalary.domain.usecase.TeacherRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {

    private final Map<Integer, Teacher> storage = new HashMap<>();

    @Override
    public void saveTeachers(List<Teacher> teachers) {
        teachers.forEach(teacher -> this.storage.put(teacher.getSerialNumber(), teacher));
        teachers.forEach(System.out::println);
    }

    @Override
    public Optional<Teacher> getTeacherBySerialNumber(int serialNumber) {
        return Optional.ofNullable(this.storage.get(serialNumber));
    }
}
