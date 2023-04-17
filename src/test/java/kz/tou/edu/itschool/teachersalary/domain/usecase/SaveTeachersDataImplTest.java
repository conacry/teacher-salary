package kz.tou.edu.itschool.teachersalary.domain.usecase;

import kz.tou.edu.itschool.teachersalary.domain.entity.Teacher;
import kz.tou.edu.itschool.teachersalary.domain.entity.exception.EmptyNameValueException;
import kz.tou.edu.itschool.teachersalary.domain.entity.exception.NegativeTeacherExperienceValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SaveTeachersDataImplTest {

    private SaveTeachersDataImpl saveTeachersData;

    @Mock
    private TeacherRepository teacherRepository;

    @BeforeEach
    void setUp() {
        this.saveTeachersData = new SaveTeachersDataImpl(this.teacherRepository);
    }

    @Test
    void execute_saveTeacherThrowException_ThrowException() {
        doThrow(new RuntimeException()).when(this.teacherRepository).saveTeachers(anyList());

        List<TeacherData> teacherList = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> this.saveTeachersData.execute(teacherList));
    }

    @Test
    void execute_allParamsValid_teachersIsSaved() {
        var teacherDataOne = new TeacherData(
                123,
                "firstNameOne",
                "lastNameOne",
                "LOW",
                2
        );

        var teacherDataTwo = new TeacherData(
                456,
                "firstNameTwo",
                "lastNameTwo",
                "HIGH",
                20
        );

        var teacherDataList = List.of(teacherDataOne, teacherDataTwo);
        assertDoesNotThrow(() -> this.saveTeachersData.execute(teacherDataList));
    }

    @Test
    void execute_firstNameIsEmpty_throwException(){
        var teacherDataOne = new TeacherData(
                145,
                "",
                "lastNameThree",
                "MEDIUM",
                3
        );

        var teacherDataList = List.of(teacherDataOne);
        assertThrows(EmptyNameValueException.class, ()-> this.saveTeachersData.execute(teacherDataList));
    }

    @Test
    void execute_lastNameIsEmpty_throwException(){
        var teacherDataOne = new TeacherData(
                145,
                "firstNameThree",
                "",
                "MEDIUM",
                3
        );

        var teacherDataList = List.of(teacherDataOne);
        assertThrows(EmptyNameValueException.class, ()-> this.saveTeachersData.execute(teacherDataList));
    }

    @Test
    void execute_qualificationIsEmpty_throwException(){
        var teacherDataOne = new TeacherData(
                145,
                "firstNameThree",
                "lastName",
                "",
                3
        );

        var teacherDataList = List.of(teacherDataOne);
        assertThrows(IllegalArgumentException.class, ()-> this.saveTeachersData.execute(teacherDataList));
    }

    @Test
    void execute_experienceIsNegative_throwException(){
        var teacherDataOne = new TeacherData(
                145,
                "firstNameThree",
                "lastName",
                "HIGH",
                -3
        );

        var teacherDataList = List.of(teacherDataOne);
        assertThrows(NegativeTeacherExperienceValueException.class, ()-> this.saveTeachersData.execute(teacherDataList));
    }
}