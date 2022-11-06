package alatoo.edu.library.services.impl;

import alatoo.edu.library.dao.AuthorRepo;
import alatoo.edu.library.dao.BookRepo;
import alatoo.edu.library.exceptions.NotFoundByIdException;
import alatoo.edu.library.mappers.AuthorMapper;
import alatoo.edu.library.mappers.BookMapper;
import alatoo.edu.library.models.dto.AuthorDto;
import alatoo.edu.library.models.entities.Author;
import alatoo.edu.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepo repo;

    @Override
    public AuthorDto save(AuthorDto authorDto) {
        return map().toDto(repo.save(map().toEntity(authorDto)));
    }

    @Override
    public AuthorDto update(AuthorDto authorDto) {
        return null;
    }

    @Override
    public AuthorDto findById(Long id) {
        return map().toDto(repo.findById(id).orElseThrow(()->new NotFoundByIdException("Author is not found!!!")));
    }

    @Override
    public List<AuthorDto> findAll() {
        return map().toDtoList(repo.findAll());
    }

    @Override
    public AuthorDto findByName(String name) {
        Author author = repo.findByName(name);
        System.out.println("Before" + author);
        if (author == null){
            author = new Author();
            author.setName(name);
            author = repo.save(author);
            System.out.println(author);
        }
        return map().toDto(author);
    }

    public AuthorMapper map() {
        return new AuthorMapper();
    }
}
