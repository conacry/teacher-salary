package kz.tou.edu.itschool.teachersalary.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NameTest {
    
    @Test
    void name_NameStrIsNull_ThrowException() {
        assertThrows(EmptyNameValueException.class, () -> new Name(null));
    }

    @Test
    void name_NameStrIsEmpty_ThrowException() {
        var emptyStr = "";
        assertThrows(EmptyNameValueException.class, () -> new Name(emptyStr));
    }

    @Test
    void name_NameStrIsValid_NameIsCreated() {
        var validNameStr = "coolName";
        var name = new Name(validNameStr);
        assertEquals(validNameStr, name.getValue());
    }
}
