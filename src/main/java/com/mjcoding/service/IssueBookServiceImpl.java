package com.mjcoding.service;

import com.mjcoding.entity.IssueBooks;
import com.mjcoding.entity.IssueBooksId;
import com.mjcoding.repository.IssueBooksRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IssueBookServiceImpl implements IssueBookService {

    @Autowired
    private IssueBooksRpository issueBooksRpository;

    @Override
    public IssueBooks issueBooks(IssueBooks books) {

        return issueBooksRpository.save(books);


    }
}
