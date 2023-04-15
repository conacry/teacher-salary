package kz.tou.edu.itschool.teachersalary.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import kz.tou.edu.itschool.teachersalary.domain.entity.exception.EmptyNameValueException;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    void of_NameStrIsNull_ThrowException() {
        assertThrows(EmptyNameValueException.class, () -> Name.of(null));
    }

    @Test
    void of_NameStrIsEmpty_ThrowException() {
        var emptyStr = "";
        assertThrows(EmptyNameValueException.class, () -> Name.of(emptyStr));
    }

    @Test
    void of_NameStrIsValid_NameIsCreated() {
        var validNameStr = "coolName";
        var name = Name.of(validNameStr);
        assertEquals(validNameStr, name.getValue());
    }
}
