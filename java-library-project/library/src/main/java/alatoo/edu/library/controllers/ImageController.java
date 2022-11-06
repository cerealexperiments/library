package alatoo.edu.library.controllers;

import alatoo.edu.library.models.dto.ImageDto;
import alatoo.edu.library.services.BookService;
import alatoo.edu.library.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/images")
public class ImageController implements BaseCrudController<ImageDto, Long>{
    @Autowired
    private ImageService service;

    @PostMapping("/save-image")
    public ResponseEntity<ImageDto> save(@RequestBody ImageDto imageDto) {
        return new ResponseEntity<>(service.save(imageDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ImageDto> update(ImageDto imageDto) {
        return null;
    }

    @Override
    public ResponseEntity<ImageDto> findById(Long id) {
        return null;
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<ImageDto>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
