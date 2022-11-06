package alatoo.edu.library.services;

import alatoo.edu.library.models.dto.LibrarianDto;

public interface LibrarianService extends BaseCrudService<LibrarianDto, Long>{
    LibrarianDto findByLogin(String login);
}
