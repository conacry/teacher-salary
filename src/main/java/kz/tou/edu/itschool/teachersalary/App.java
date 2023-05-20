package kz.tou.edu.itschool.teachersalary;

import kz.tou.edu.itschool.teachersalary.adapter.controller.TeacherCsvController;
import kz.tou.edu.itschool.teachersalary.adapter.repository.TeacherRepositoryImpl;
import kz.tou.edu.itschool.teachersalary.domain.usecase.CalcTeacherSalaryImpl;
import kz.tou.edu.itschool.teachersalary.domain.usecase.SaveTeachersDataImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.FileNotFoundException;
import java.nio.file.Path;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
