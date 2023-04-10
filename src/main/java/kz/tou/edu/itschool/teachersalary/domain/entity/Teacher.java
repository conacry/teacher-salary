package kz.tou.edu.itschool.teachersalary.domain.entity;

import java.util.UUID;

public class Teacher {

    private final UUID id;
    private Name firstName;
    private Name lastName;
    private Qualification qualification;
    private int experience;

    private Teacher(
            UUID id,
            Name firstName,
            Name lastName,
            Qualification qualification,
            int experience
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.qualification = qualification;
        this.experience = experience;
    }

    public UUID getId() {
        return id;
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

    public int getExperience() {
        return experience;
    }

    public static class TeacherBuilder {
        private UUID id;
        private Name firstName;
        private Name lastName;
        private Qualification qualification;
        private int experience;

        public TeacherBuilder() {
        }

        public TeacherBuilder UUID(UUID id) {
            this.id = id;
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

        public TeacherBuilder experience(int experience) {
            this.experience = experience;
            return this;
        }

        public Teacher build() {
            //Validation
            return new Teacher(
                    this.id,
                    this.firstName,
                    this.lastName,
                    this.qualification,
                    this.experience
            );
        }
    }
}
