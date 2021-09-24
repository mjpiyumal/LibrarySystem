package com.mjcoding.service;

import com.mjcoding.dto.ResponseDto;
import com.mjcoding.entity.Books;
import com.mjcoding.entity.IssueBooks;
import com.mjcoding.repository.BooksRepository;
import com.mjcoding.utill.BookNoFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksRepository booksRepository;


    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Books bookInsertion(Books books) {
        return booksRepository.save(books);
    }


    @Override
    public List<ResponseDto> getAll() {
        return ((List<Books>) booksRepository
                .findAll())
                .stream()
                .map(this::convertResponseDto)
                .collect(Collectors.toList());
    }

    public ResponseDto convertResponseDto(Books books) {

        ResponseDto dto = new ResponseDto();
        dto.setStatus(HttpStatus.OK);
        List<IssueBooks> list = books.getIssuedBooks();
        dto.setBook_reference(books.getBook_reference());
        dto.setTitle(books.getTitle());
        dto.setAuthor(books.getAuthor());

        Stream<Object> sName = list.stream().map(a ->
                a.getStudents().getFirst_name() + " " + a.getStudents().getLast_name());
        dto.setStudentsNames(sName);

        return dto;
    }

    @Override
    public ResponseDto findById(Long id) {
        ResponseDto dto = new ResponseDto();
        Books books = booksRepository.findById(id).orElseThrow(() -> new BookNoFoundException("Not found this book"));
        dto.setStatus(HttpStatus.OK);
        dto.setBook_reference(books.getBook_reference());
        dto.setTitle(books.getTitle());
        dto.setAuthor(books.getAuthor());

        Stream<Object> sName = books.getIssuedBooks().stream().map(a ->
                a.getStudents().getFirst_name() + " " + a.getStudents().getLast_name());
        dto.setStudentsNames(sName);
        return dto;
    }

    @Override
    public ResponseDto findByTitle(String title) {
        ResponseDto dto = new ResponseDto();
        Books books = booksRepository.findByName(title);
        dto.setStatus(HttpStatus.OK);
        dto.setBook_reference(books.getBook_reference());
        dto.setTitle(books.getTitle());
        dto.setAuthor(books.getAuthor());

        Stream<Object> sName = books.getIssuedBooks().stream().map(a ->
                a.getStudents().getFirst_name() + " " + a.getStudents().getLast_name());
        dto.setStudentsNames(sName);
        return dto;
    }

    //    public ResponseDto convertResponseDto(Books books) {

    //ModelMapper
//        modelMapper.getConfiguration()
//                .setMatchingStrategy(MatchingStrategies.LOOSE);
//        ResponseDto dto = modelMapper
//                .map(books, ResponseDto.class);
//        return dto;

//    }


}
