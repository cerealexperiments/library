package alatoo.edu.library.services.impl;

import alatoo.edu.library.dao.ReaderRepo;
import alatoo.edu.library.dao.UserRepo;
import alatoo.edu.library.exceptions.NotFoundByIdException;
import alatoo.edu.library.mappers.LibrarianMapper;
import alatoo.edu.library.mappers.ReaderMapper;
import alatoo.edu.library.mappers.UserMapper;
import alatoo.edu.library.models.dto.ReaderDto;
import alatoo.edu.library.models.dto.UserDto;
import alatoo.edu.library.models.entities.Reader;
import alatoo.edu.library.models.entities.User;
import alatoo.edu.library.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDto save(UserDto readerDto) {
        return map().toDto(repo.save(map().toEntity(readerDto)));
    }

    @Override
    public UserDto update(UserDto readerDto) {
        return null;
    }

    @Override
    public UserDto findById(Long id) {
        return map().toDto(repo.findById(id).orElseThrow(()->new NotFoundByIdException("Reader is not found!!!")));
    }

    @Override
    public List<UserDto> findAll() {
        return map().toDtoList(repo.findAll());
    }

    public UserMapper map() {
        return new UserMapper();
    }

//    @Override
//    public UserDto findByLogin(String login) {
//        User reader = repo.findByLogin(login);
//        if (reader == null){
//            throw new NotFoundByIdException("Reader is not found!!!");
//        }
//        return map().toDto(reader);
//    }

    @Override
    public User findEntityById(Long id) {
        return repo.findById(id).orElseThrow(()->new NotFoundByIdException("Reader is not found!!!"));
    }
}
