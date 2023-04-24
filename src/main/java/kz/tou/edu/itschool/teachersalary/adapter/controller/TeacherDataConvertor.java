package kz.tou.edu.itschool.teachersalary.adapter.controller;

import kz.tou.edu.itschool.teachersalary.adapter.csv.model.TeacherDataBean;
import kz.tou.edu.itschool.teachersalary.adapter.csv.model.TeacherSalaryDataBean;
import kz.tou.edu.itschool.teachersalary.adapter.csv.model.WorkDayDataBean;
import kz.tou.edu.itschool.teachersalary.domain.usecase.TeacherData;
import kz.tou.edu.itschool.teachersalary.domain.usecase.TeacherSalaryData;
import kz.tou.edu.itschool.teachersalary.domain.usecase.TeacherWorkDayData;

import java.util.List;

public class TeacherDataConvertor {

    public static List<TeacherData> teacherDataBeansToModels(List<TeacherDataBean> beans) {
        return beans.stream().map(TeacherDataConvertor::teacherDataBeanToModel).toList();
    }

    private static TeacherData teacherDataBeanToModel(TeacherDataBean bean) {
        return new TeacherData(
                bean.getSerialNumber(),
                bean.getFirstName(),
                bean.getLastName(),
                bean.getQualification(),
                bean.getExperience()
        );
    }

    public static List<TeacherWorkDayData> workDayDataBeansToModels(List<WorkDayDataBean> beans) {
        return beans.stream().map(TeacherDataConvertor::workDayDataBeanToModel).toList();
    }

    private static TeacherWorkDayData workDayDataBeanToModel(WorkDayDataBean bean) {
        return new TeacherWorkDayData(
                bean.getSerialNumber(),
                bean.getWorkDays()
        );
    }

    public static List<TeacherSalaryDataBean> teacherSalaryDataModelsToBeans(List<TeacherSalaryData> models){
        return models.stream().map(TeacherDataConvertor::teacherSalaryDataModelToBean).toList();
    }

    private static TeacherSalaryDataBean teacherSalaryDataModelToBean(TeacherSalaryData model) {
        var bean = new TeacherSalaryDataBean();
        bean.setSerialNumber(model.serialNumber());
        bean.setLastName(model.lastName());
        bean.setFirstName(model.firstName());
        bean.setAmount(model.salary());
        return bean;
    }
}
