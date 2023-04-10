package kz.tou.edu.itschool.teachersalary.domain.entity;

import kz.tou.edu.itschool.teachersalary.domain.entity.exception.EmptyNameValueException;

public class Name {

    private String value;

    public Name(String nameStr) {
        if (nameStr == null || nameStr.isBlank()) {
            throw new EmptyNameValueException();
        }

        this.value = nameStr;
    }

    public String getValue() {
        return this.value;
    }
}
