package com.mjcoding.repository;

import com.mjcoding.entity.IssueBooks;
import com.mjcoding.entity.IssueBooksId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueBooksRpository extends JpaRepository<IssueBooks, IssueBooksId> {
}
