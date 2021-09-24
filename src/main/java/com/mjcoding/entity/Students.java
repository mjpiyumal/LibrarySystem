package com.mjcoding.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
@JsonIdentityInfo(scope = Students.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "studentId")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Long studentId;
    private String first_name;
    private String last_name;
    private String email;
    private String address;
    private String telephone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date registered_date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date terminated_date;

    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<IssueBooks> issuedBooks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Students)) return false;
        Students students = (Students) o;
        return getStudentId() == students.getStudentId() && getFirst_name().equals(students.getFirst_name()) && getLast_name().equals(students.getLast_name()) && getEmail().equals(students.getEmail()) && getAddress().equals(students.getAddress()) && getTelephone().equals(students.getTelephone()) && getRegistered_date().equals(students.getRegistered_date()) && getTerminated_date().equals(students.getTerminated_date()) && getIssuedBooks().equals(students.getIssuedBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getFirst_name(), getLast_name(), getEmail(), getAddress(), getTelephone(), getRegistered_date(), getTerminated_date(), getIssuedBooks());
    }
}
