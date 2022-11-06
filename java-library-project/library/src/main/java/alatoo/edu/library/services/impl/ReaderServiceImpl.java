package alatoo.edu.library.services.impl;

import alatoo.edu.library.dao.ReaderRepo;
import alatoo.edu.library.exceptions.NotFoundByIdException;
import alatoo.edu.library.mappers.LibrarianMapper;
import alatoo.edu.library.mappers.ReaderMapper;
import alatoo.edu.library.models.dto.ReaderDto;
import alatoo.edu.library.models.entities.Reader;
import alatoo.edu.library.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderRepo repo;

    @Override
    public ReaderDto save(ReaderDto readerDto) {
        readerDto.set_active(true); // Newly created reader will be active by default
        return map().toDto(repo.save(map().toEntity(readerDto)));
    }

    @Override
    public ReaderDto update(ReaderDto readerDto) {
        return null;
    }

    @Override
    public ReaderDto findById(Long id) {
        return map().toDto(repo.findById(id).orElseThrow(()->new NotFoundByIdException("Reader is not found!!!")));
    }

    @Override
    public List<ReaderDto> findAll() {
        return map().toDtoList(repo.findAll());
    }

    public ReaderMapper map() {
        return new ReaderMapper();
    }

    @Override
    public ReaderDto findByLogin(String login) {
        Reader reader = repo.findByLogin(login);
        if (reader == null){
            throw new NotFoundByIdException("Reader is not found!!!");
        }
        return map().toDto(reader);
    }
}
