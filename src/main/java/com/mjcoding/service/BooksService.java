package com.mjcoding.service;

import com.mjcoding.dto.ResponseDto;
import com.mjcoding.entity.Books;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BooksService {

    Books bookInsertion(Books books);

    ResponseDto findById(Long id);

    List<ResponseDto> getAll();

    ResponseDto findByTitle(String title);

}
