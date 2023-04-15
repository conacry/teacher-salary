package kz.tou.edu.itschool.teachersalary.domain.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
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

    }
}