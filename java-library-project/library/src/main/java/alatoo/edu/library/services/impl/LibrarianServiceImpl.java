package alatoo.edu.library.services.impl;

import alatoo.edu.library.dao.LibrarianRepo;
import alatoo.edu.library.exceptions.NotFoundByIdException;
import alatoo.edu.library.mappers.ImageMapper;
import alatoo.edu.library.mappers.LibrarianMapper;
import alatoo.edu.library.models.dto.LibrarianDto;
import alatoo.edu.library.services.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibrarianServiceImpl implements LibrarianService {
    @Autowired
    private LibrarianRepo repo;

    @Override
    public LibrarianDto save(LibrarianDto librarianDto) {
        return map().toDto(repo.save(map().toEntity(librarianDto)));
    }

    @Override
    public LibrarianDto update(LibrarianDto librarianDto) {
        return null;
    }

    @Override
    public LibrarianDto findById(Long id) {
        return map().toDto(repo.findById(id).orElseThrow(()->new NotFoundByIdException("Librarian is not found!!!")));
    }

    @Override
    public List<LibrarianDto> findAll() {
        return map().toDtoList(repo.findAll());
    }

    public LibrarianMapper map() {
        return new LibrarianMapper();
    }

    @Override
    public LibrarianDto findByLogin(String login) {
        return null;
    }
}
