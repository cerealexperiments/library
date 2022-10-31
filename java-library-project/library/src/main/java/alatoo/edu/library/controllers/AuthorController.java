package alatoo.edu.library.controllers;

import alatoo.edu.library.models.dto.AuthorDto;
import alatoo.edu.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/authors")
public class AuthorController implements BaseCrudController<AuthorDto,Long>{
    @Autowired
    private AuthorService service;

    @PostMapping("/save-author")
    public ResponseEntity<AuthorDto> save(@RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(service.save(authorDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AuthorDto> update(AuthorDto authorDto) {
        return null;
    }

    @Override
    public ResponseEntity<AuthorDto> findById(Long id) {
        return null;
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<AuthorDto>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
