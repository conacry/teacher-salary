package kz.tou.edu.itschool.teachersalary.adapter.csv.model;

import com.opencsv.bean.CsvBindByPosition;

public class TeacherDataBean {

    @CsvBindByPosition(position = 0)
    private int serialNumber;

    @CsvBindByPosition(position = 1)
    private String firstName;

    @CsvBindByPosition(position = 2)
    private String lastName;

    @CsvBindByPosition(position = 3)
    private String qualification;

    @CsvBindByPosition(position = 4)
    private int experience;

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getQualification() {
        return qualification;
    }

    public int getExperience() {
        return experience;
    }
}
