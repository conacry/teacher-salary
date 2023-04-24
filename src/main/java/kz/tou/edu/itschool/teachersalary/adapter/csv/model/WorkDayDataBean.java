package kz.tou.edu.itschool.teachersalary.adapter.csv.model;

import com.opencsv.bean.CsvBindByPosition;

public class WorkDayDataBean {

    @CsvBindByPosition(position = 0)
    private int serialNumber;

    @CsvBindByPosition(position = 1)
    private int workDays;


    public int getSerialNumber() {
        return serialNumber;
    }

    public int getWorkDays() {
        return workDays;
    }
}
