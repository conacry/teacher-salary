package kz.tou.edu.itschool.teachersalary.domain.entity;

public interface SalaryCalculator {
    int calc(Teacher teacher, int workedDays);
}
