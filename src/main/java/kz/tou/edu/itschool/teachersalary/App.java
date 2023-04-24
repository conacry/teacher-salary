package kz.tou.edu.itschool.teachersalary;

import kz.tou.edu.itschool.teachersalary.adapter.controller.TeacherCsvController;
import kz.tou.edu.itschool.teachersalary.adapter.repository.TeacherRepositoryImpl;
import kz.tou.edu.itschool.teachersalary.domain.usecase.CalcTeacherSalaryImpl;
import kz.tou.edu.itschool.teachersalary.domain.usecase.SaveTeachersDataImpl;

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
        var calcTeacherSalary = new CalcTeacherSalaryImpl(teacherRepo);
        var controller = new TeacherCsvController(
                saveTeacherUseCase,
                calcTeacherSalary
        );

        controller.saveTeachersFromCsv(Path.of("etc/csv/teacherData.csv"));
        controller.calcTeacherSalary(
                Path.of("etc/csv/teacherWorkDays.csv"),
                Path.of("etc/csv/teacherSalary.csv")
        );
    }
}
