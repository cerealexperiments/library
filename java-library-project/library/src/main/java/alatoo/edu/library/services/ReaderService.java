package alatoo.edu.library.services;

import alatoo.edu.library.models.dto.ReaderDto;

public interface ReaderService extends BaseCrudService<ReaderDto, Long>{
    ReaderDto findByLogin(String login);
}
