package kz.tou.edu.itschool.teachersalary.adapter.controller;

import kz.tou.edu.itschool.teachersalary.adapter.csv.reader.CsvReader;
import kz.tou.edu.itschool.teachersalary.adapter.csv.model.TeacherDataBean;
import kz.tou.edu.itschool.teachersalary.domain.usecase.SaveTeachersData;

import java.nio.file.Path;

public class TeacherController {

    private final SaveTeachersData saveTeachersData;

    public TeacherController(SaveTeachersData saveTeachersData) {
        this.saveTeachersData = saveTeachersData;
    }

    public void saveTeachersFromCsv(Path path) {
        var csvBeans = CsvReader.read(path, TeacherDataBean.class);

        var teacherData = TeacherDataConvertor.beansToModels(csvBeans);

        saveTeachersData.execute(teacherData);
    }
}
