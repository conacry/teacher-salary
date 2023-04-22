package kz.tou.edu.itschool.teachersalary.domain.entity;

import java.util.UUID;

public class Teacher {

    private final UUID id;

    private int serialNumber;

    private Name firstName;
    private Name lastName;
    private Qualification qualification;
    private TeacherExperience experience;

    private Teacher(
            UUID id,
            int serialNumber,
            Name firstName,
            Name lastName,
            Qualification qualification,
            TeacherExperience experience
    ) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.qualification = qualification;
        this.experience = experience;
    }

    public UUID getId() {
        return id;
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public Name getFirstName() {
        return firstName;
    }

    public Name getLastName() {
        return lastName;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public TeacherExperience getExperience() {
        return experience;
    }

    public static class TeacherBuilder {
        private UUID id;

        private int serialNumber;

        private Name firstName;
        private Name lastName;
        private Qualification qualification;
        private TeacherExperience experience;

        public TeacherBuilder() {
        }

        public TeacherBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public TeacherBuilder serialNumber(int serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public TeacherBuilder firstName(Name firstName) {
            this.firstName = firstName;
            return this;
        }

        public TeacherBuilder lastName(Name lastName) {
            this.lastName = lastName;
            return this;
        }

        public TeacherBuilder qualification(Qualification qualification) {
            this.qualification = qualification;
            return this;
        }

        public TeacherBuilder experience(TeacherExperience experience) {
            this.experience = experience;
            return this;
        }

        public Teacher build() {
            //Validation
            return new Teacher(
                    this.id,
                    this.serialNumber,
                    this.firstName,
                    this.lastName,
                    this.qualification,
                    this.experience
            );
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", serialNumber=" + serialNumber +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", qualification=" + qualification +
                ", experience=" + experience +
                '}';
    }
}
