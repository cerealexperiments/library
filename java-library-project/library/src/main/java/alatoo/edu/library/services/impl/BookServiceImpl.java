package alatoo.edu.library.services.impl;

import alatoo.edu.library.dao.BookRepo;
import alatoo.edu.library.exceptions.NotFoundByIdException;
import alatoo.edu.library.mappers.BookMapper;
import alatoo.edu.library.models.dto.AuthorDto;
import alatoo.edu.library.models.dto.BookDto;
import alatoo.edu.library.models.dto.ImageDto;
import alatoo.edu.library.models.entities.Book;
import alatoo.edu.library.models.input_dtos.InputBookDto;
import alatoo.edu.library.services.AuthorService;
import alatoo.edu.library.services.BaseCrudService;
import alatoo.edu.library.services.BookService;
import alatoo.edu.library.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo repo;
    @Autowired
    private ImageService imageService;
    @Autowired
    private AuthorService authorService;

    public InputBookDto saveInputBookDto(InputBookDto inputBookDto){
        BookDto bookDto = new BookDto();
        AuthorDto authorDto = authorService.findByName(inputBookDto.getAuthorName());

        bookDto.setAuthorDto(authorDto);
        bookDto.setName(inputBookDto.getName());
        bookDto.setPublishing_date(inputBookDto.getPublishing_date());
        bookDto.setGenre(inputBookDto.getGenre());
        bookDto.setPrice(inputBookDto.getPrice());
        bookDto = save(bookDto);

        ImageDto imageDto = new ImageDto();
        imageDto.setBookDto(bookDto);
        imageDto.setUrl(inputBookDto.getImageUrl());
        imageDto = imageService.save(imageDto);

        InputBookDto inputBookDtoOutput = new InputBookDto();
        inputBookDtoOutput.setGenre(bookDto.getGenre());
        inputBookDtoOutput.setName(bookDto.getName());
        inputBookDtoOutput.setPrice(bookDto.getPrice());
        inputBookDtoOutput.setPublishing_date(bookDto.getPublishing_date());
        inputBookDtoOutput.setAuthorName(authorDto.getName());
        inputBookDtoOutput.setImageUrl(imageDto.getUrl());
        return inputBookDtoOutput;
    }

    @Override
    public BookDto save(BookDto bookDto) {
        return map().toDto(repo.save(map().toEntity(bookDto)));
    }

    @Override
    public BookDto update(BookDto bookDto) {
        return null;
    }

    @Override
    public BookDto findById(Long id) {
        return map().toDto(repo.findById(id).orElseThrow(()->new NotFoundByIdException("Book is not found!!!")));
    }

    @Override
    public List<BookDto> findAll() {
        return map().toDtoList(repo.findAll());
    }

    public BookMapper map() {
        BookMapper bookMapper = new BookMapper();
        return bookMapper;
    }
}
