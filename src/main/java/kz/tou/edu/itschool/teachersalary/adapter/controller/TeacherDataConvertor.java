package kz.tou.edu.itschool.teachersalary.adapter.controller;

import kz.tou.edu.itschool.teachersalary.adapter.csv.model.TeacherDataBean;
import kz.tou.edu.itschool.teachersalary.domain.usecase.TeacherData;

import java.util.List;

public class TeacherDataConvertor {

    public static List<TeacherData> beansToModels(List<TeacherDataBean> beans) {
        return beans.stream().map(TeacherDataConvertor::beanToModel).toList();
    }

    private static TeacherData beanToModel(TeacherDataBean bean) {
        return new TeacherData(
                bean.getSerialNumber(),
                bean.getFirstName(),
                bean.getLastName(),
                bean.getQualification(),
                bean.getExperience()
                );
    }
}
