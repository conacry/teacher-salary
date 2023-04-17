package kz.tou.edu.itschool.teachersalary.domain.entity;

import java.math.BigDecimal;

public interface SalaryCalculator {
    BigDecimal calc(Teacher teacher, int workedDays);
}
