package com.mjcoding.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "issueBooks")
@JsonIdentityInfo(scope = IssueBooks.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "issueBooksId")
public class IssueBooks {

    @EmbeddedId
    IssueBooksId issueBooksId = new IssueBooksId();

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @MapsId("bookId")
    @JoinColumn(name = "bookId")
    private Books books;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @MapsId("studentId")
    @JoinColumn(name = "studentId")
    private Students students;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date issueDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date returnDate;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IssueBooks)) return false;
        IssueBooks that = (IssueBooks) o;
        return getIssueBooksId().equals(that.getIssueBooksId()) && getBooks().equals(that.getBooks()) && getStudents().equals(that.getStudents()) && getIssueDate().equals(that.getIssueDate()) && getReturnDate().equals(that.getReturnDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIssueBooksId(), getBooks(), getStudents(), getIssueDate(), getReturnDate());
    }
}
