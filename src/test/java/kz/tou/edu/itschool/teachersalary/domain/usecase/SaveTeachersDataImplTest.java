package kz.tou.edu.itschool.teachersalary.domain.usecase;

import kz.tou.edu.itschool.teachersalary.domain.entity.Teacher;
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
}