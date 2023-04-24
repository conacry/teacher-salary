package kz.tou.edu.itschool.teachersalary.adapter.controller;

import kz.tou.edu.itschool.teachersalary.adapter.csv.model.TeacherSalaryDataBean;
import kz.tou.edu.itschool.teachersalary.adapter.csv.model.WorkDayDataBean;
import kz.tou.edu.itschool.teachersalary.adapter.csv.reader.CsvReader;
import kz.tou.edu.itschool.teachersalary.adapter.csv.model.TeacherDataBean;
import kz.tou.edu.itschool.teachersalary.adapter.csv.writer.CsvWriter;
import kz.tou.edu.itschool.teachersalary.domain.usecase.CalcTeacherSalary;
import kz.tou.edu.itschool.teachersalary.domain.usecase.SaveTeachersData;

import java.nio.file.Path;

public class TeacherCsvController {

    private final SaveTeachersData saveTeachersData;
    private final CalcTeacherSalary calcTeacherSalary;

    public TeacherCsvController(SaveTeachersData saveTeachersData, CalcTeacherSalary calcTeacherSalary) {
        this.saveTeachersData = saveTeachersData;
        this.calcTeacherSalary = calcTeacherSalary;
    }

    public void saveTeachersFromCsv(Path path) {
        var csvBeans = CsvReader.read(path, TeacherDataBean.class);

        var teacherData = TeacherDataConvertor.teacherDataBeansToModels(csvBeans);

        saveTeachersData.execute(teacherData);
    }

    public void calcTeacherSalary(Path workDayDataCsv, Path teacherDataCsv) {
        var csvWorkdaysDataBeans = CsvReader.read(workDayDataCsv, WorkDayDataBean.class);

        var teacherWorkDayData = TeacherDataConvertor.workDayDataBeansToModels(csvWorkdaysDataBeans);

        var teacherSalaryData = calcTeacherSalary.execute(teacherWorkDayData);

        var teacherSalaryDataBeans = TeacherDataConvertor.teacherSalaryDataModelsToBeans(teacherSalaryData);
        CsvWriter.write(teacherDataCsv, teacherSalaryDataBeans, TeacherSalaryDataBean.class);
    }
}
