package alatoo.edu.library.controllers;

import alatoo.edu.library.models.dto.BookDto;
import alatoo.edu.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController implements BaseCrudController<BookDto,Long>{
    @Autowired
    private BookService service;

    @PostMapping("/save-book")
    public ResponseEntity<BookDto> save(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(service.save(bookDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BookDto> update(BookDto bookDto) {
        return null;
    }

    @Override
    public ResponseEntity<BookDto> findById(Long id) {
        return null;
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<BookDto>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
