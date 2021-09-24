package com.mjcoding.entity;

import com.fasterxml.jackson.annotation.*;
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
@Table(name = "books")
@JsonIdentityInfo(scope = Books.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "bookId")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String book_reference;
    private String isbn;
    private String title;
    private String author;
    private String publication;
    private String edition;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date published_year;
    private String category;
    private int number_of_copies;

    @OneToMany(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<IssueBooks> issuedBooks;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Books)) return false;
        Books books = (Books) o;
        return getBookId() == books.getBookId() && getNumber_of_copies() == books.getNumber_of_copies() && getBook_reference()
                .equals(books.getBook_reference()) && getIsbn()
                .equals(books.getIsbn()) && getTitle().equals(books.getTitle()) && getAuthor()
                .equals(books.getAuthor()) && getPublication().equals(books.getPublication()) && getEdition()
                .equals(books.getEdition()) && getPublished_year().equals(books.getPublished_year()) && getCategory()
                .equals(books.getCategory()) && getIssuedBooks().equals(books.getIssuedBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getBook_reference(),
                getIsbn(), getTitle(), getAuthor(),
                getPublication(), getEdition(), getPublished_year(),
                getCategory(), getNumber_of_copies(), getIssuedBooks());
    }
}
