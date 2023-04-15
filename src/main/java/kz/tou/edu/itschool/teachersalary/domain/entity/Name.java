package kz.tou.edu.itschool.teachersalary.domain.entity;

import kz.tou.edu.itschool.teachersalary.domain.entity.exception.EmptyNameValueException;

public class Name {

    private final String value;

    public static Name of(String nameStr) {
        if (nameStr == null || nameStr.isBlank()) {
            throw new EmptyNameValueException();
        }

        return new Name(nameStr);
    }

    private Name(String nameStr) {
        this.value = nameStr;
    }

    public String getValue() {
        return this.value;
    }
}
