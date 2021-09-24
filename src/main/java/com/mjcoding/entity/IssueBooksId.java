package com.mjcoding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class IssueBooksId implements Serializable {

    @Column(name = "bookId")
    private Long bookId;
    @Column(name = "studentId")
    private Long studentId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IssueBooksId)) return false;
        IssueBooksId that = (IssueBooksId) o;
        return getBookId() == that.getBookId() && getStudentId() == that.getStudentId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getStudentId());
    }
}
