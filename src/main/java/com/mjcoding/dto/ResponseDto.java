package com.mjcoding.dto;

import com.mjcoding.entity.IssueBooks;
import com.mjcoding.entity.Students;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.net.http.HttpClient;
import java.util.List;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private HttpStatus status;
    private String book_reference;
    private String title;
    private String author;
    private Stream<Object> studentsNames;
}
