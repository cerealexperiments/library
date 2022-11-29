package alatoo.edu.library.controllers;

import alatoo.edu.library.models.dto.BookDto;
import alatoo.edu.library.models.input_dtos.InputBookDto;
import alatoo.edu.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController implements BaseCrudController<BookDto,Long>{
    @Autowired
    private BookService service;

    @PostMapping("/save-book")
    public ResponseEntity<InputBookDto> save(@RequestBody InputBookDto inputBookDto) {
        return new ResponseEntity<>(service.saveInputBookDto(inputBookDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BookDto> save(BookDto bookDto) {
        return null;
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
