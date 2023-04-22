package kz.tou.edu.itschool.teachersalary;

import kz.tou.edu.itschool.teachersalary.adapter.controller.TeacherController;
import kz.tou.edu.itschool.teachersalary.adapter.repository.TeacherRepositoryImpl;
import kz.tou.edu.itschool.teachersalary.domain.usecase.SaveTeachersDataImpl;
import kz.tou.edu.itschool.teachersalary.domain.usecase.TeacherRepository;

import java.io.FileNotFoundException;
import java.nio.file.Path;

/**
 * Hello world!
 *
 */
public class App {
    
    public static void main(String[] args) throws FileNotFoundException {
        var teacherRepo = new TeacherRepositoryImpl();
        var saveTeacherUseCase = new SaveTeachersDataImpl(teacherRepo);
        var controller = new TeacherController(saveTeacherUseCase);

        controller.saveTeachersFromCsv(Path.of("etc/csv/teacherData.csv"));
    }
}
