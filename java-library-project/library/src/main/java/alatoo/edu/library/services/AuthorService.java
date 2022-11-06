package alatoo.edu.library.services;

import alatoo.edu.library.models.dto.AuthorDto;

public interface AuthorService extends BaseCrudService<AuthorDto,Long>{
    AuthorDto findByName(String name);
}
