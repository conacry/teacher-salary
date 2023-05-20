package kz.tou.edu.itschool.teachersalary.adapter.controller;

import kz.tou.edu.itschool.teachersalary.adapter.csv.model.TeacherSalaryDataBean;
import kz.tou.edu.itschool.teachersalary.adapter.csv.model.WorkDayDataBean;
import kz.tou.edu.itschool.teachersalary.adapter.csv.reader.CsvReader;
import kz.tou.edu.itschool.teachersalary.adapter.csv.model.TeacherDataBean;
import kz.tou.edu.itschool.teachersalary.adapter.csv.writer.CsvWriter;
import kz.tou.edu.itschool.teachersalary.domain.usecase.CalcTeacherSalary;
import kz.tou.edu.itschool.teachersalary.domain.usecase.SaveTeachersData;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.Path;

@Controller
@RequestMapping(path = "/api/v1")
public class TeacherCsvController {

    private final SaveTeachersData saveTeachersData;
    private final CalcTeacherSalary calcTeacherSalary;

    public TeacherCsvController(SaveTeachersData saveTeachersData, CalcTeacherSalary calcTeacherSalary) {
        this.saveTeachersData = saveTeachersData;
        this.calcTeacherSalary = calcTeacherSalary;
    }

    @PostMapping(path = "save")
    public void saveTeachersFromCsv() {
        var csvBeans = CsvReader.read(Path.of("etc/csv/teacherData.csv"), TeacherDataBean.class);

        var teacherData = TeacherDataConvertor.teacherDataBeansToModels(csvBeans);

        saveTeachersData.execute(teacherData);
    }

    @PostMapping(path = "calc")
    public void calcTeacherSalary() {
        var csvWorkdaysDataBeans = CsvReader.read(Path.of("etc/csv/teacherWorkDays.csv"), WorkDayDataBean.class);

        var teacherWorkDayData = TeacherDataConvertor.workDayDataBeansToModels(csvWorkdaysDataBeans);

        var teacherSalaryData = calcTeacherSalary.execute(teacherWorkDayData);

        var teacherSalaryDataBeans = TeacherDataConvertor.teacherSalaryDataModelsToBeans(teacherSalaryData);
        CsvWriter.write( Path.of("etc/csv/teacherSalary.csv"), teacherSalaryDataBeans, TeacherSalaryDataBean.class);
    }
}
