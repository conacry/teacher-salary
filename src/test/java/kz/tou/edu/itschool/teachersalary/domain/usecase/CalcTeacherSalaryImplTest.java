package kz.tou.edu.itschool.teachersalary.domain.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalcTeacherSalaryImplTest {


    private CalcTeacherSalaryImpl calcTeacherSalary;

    @Mock
    private TeacherRepository teacherRepository;

    @BeforeEach
    void setUp() {
        this.calcTeacherSalary = new CalcTeacherSalaryImpl(this.teacherRepository);
    }

    @Test
    void execute_RepoThrowException_ThrowException() {
        when(teacherRepository.getTeacherBySerialNumber(anyInt())).thenThrow(RuntimeException.class);

        var teacherWorkDayData = new ArrayList<TeacherWorkDayData>();
        var workDayData = new TeacherWorkDayData(123, 10);
        teacherWorkDayData.add(workDayData);

        assertThrows(RuntimeException.class, () -> this.calcTeacherSalary.execute(teacherWorkDayData));
    }
}