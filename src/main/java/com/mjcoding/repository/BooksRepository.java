package com.mjcoding.repository;

import com.mjcoding.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BooksRepository extends JpaRepository<Books, Long> {

    @Query("SELECT a FROM Books a where a.title = ?1")
    Books findByName(String title);

}
