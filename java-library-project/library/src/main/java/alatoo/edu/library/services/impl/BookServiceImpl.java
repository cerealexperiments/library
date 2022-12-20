package alatoo.edu.library.services.impl;

import alatoo.edu.library.dao.BookRepo;
import alatoo.edu.library.dao.ReaderRepo;
import alatoo.edu.library.dao.SaveBookRepo;
import alatoo.edu.library.dao.UserRepo;
import alatoo.edu.library.exceptions.NotFoundByIdException;
import alatoo.edu.library.mappers.AuthorMapper;
import alatoo.edu.library.mappers.BookMapper;
import alatoo.edu.library.mappers.SaveBookMapper;
import alatoo.edu.library.models.dto.AuthorDto;
import alatoo.edu.library.models.dto.BookDto;
import alatoo.edu.library.models.dto.ImageDto;
import alatoo.edu.library.models.dto.SaveBookDto;
import alatoo.edu.library.models.entities.Book;
import alatoo.edu.library.models.entities.Reader;
import alatoo.edu.library.models.entities.User;
import alatoo.edu.library.models.input_dtos.InputBookDto;
import alatoo.edu.library.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo repo;
    @Autowired
    private ImageService imageService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private SaveBookRepo saveBookRepo;
    @Autowired
    private UserRepo readerRepo;
    @Autowired
    private ReaderService readerService;

    public InputBookDto saveInputBookDto(InputBookDto inputBookDto){
        BookDto bookDto = new BookDto();
        AuthorDto authorDto = authorService.findByName(inputBookDto.getAuthorName());

        bookDto.setAuthorDto(authorDto);
        bookDto.setName(inputBookDto.getName());
        bookDto.setPublishingDate(inputBookDto.getPublishingDate());
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
        inputBookDtoOutput.setPublishingDate(bookDto.getPublishingDate());
        inputBookDtoOutput.setAuthorName(authorDto.getName());
        inputBookDtoOutput.setImageUrl(imageDto.getUrl());
        return inputBookDtoOutput;
    }

    @Override
    public List<BookDto> findByName(String name) {
        System.out.println(name);
        System.out.println(repo.findByName(name));
        return map().toDtoList(repo.findByName(name));
    }

    @Override
    public List<BookDto> findByAuthor(String authorName) {
        return map().toDtoList(repo.findByAuthor(authorMap().toEntity(authorService.findByName(authorName))));
    }

    @Override
    public List<BookDto> findByPublishingDate(int publishingDate) {
        return map().toDtoList(repo.findByPublishingDate(publishingDate));
    }

    @Override
    public List<BookDto> alreadyReadBooks(Long readerId) {
        User reader = readerRepo.findById(readerId).orElseThrow(()->new NotFoundByIdException("Reader is not found!!!"));
        List<SaveBookDto> saveBookDtos = saveBookMapper().toDtoList(saveBookRepo.findByUserAndIsRead(reader, true));
        return saveBookDtos.stream().map(SaveBookDto::getBookDto).collect(Collectors.toList());
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
    public Book findEntityById(Long id) {
        return repo.findById(id).orElseThrow(()->new NotFoundByIdException("Book is not found!!!"));
    }

    @Override
    public List<BookDto> findFavouriteBooks(Long readerId) {
        User reader = readerRepo.findById(readerId).orElseThrow(()->new NotFoundByIdException("Reader is not found!!!"));
        List<SaveBookDto> saveBookDtos = saveBookMapper().toDtoList(saveBookRepo.findByUserAndIsFavourite(reader, true));
        return saveBookDtos.stream().map(SaveBookDto::getBookDto).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findAll() {
        return map().toDtoList(repo.findAll());
    }

    public BookMapper map() {
        BookMapper bookMapper = new BookMapper();
        return bookMapper;
    }

    public AuthorMapper authorMap(){
        return new AuthorMapper();
    }

    public SaveBookMapper saveBookMapper() {
        return new SaveBookMapper();
    }
}
