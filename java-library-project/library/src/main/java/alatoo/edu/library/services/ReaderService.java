package alatoo.edu.library.services;

import alatoo.edu.library.models.dto.ReaderDto;
import alatoo.edu.library.models.dto.UserDto;
import alatoo.edu.library.models.entities.Reader;
import alatoo.edu.library.models.entities.User;

public interface ReaderService extends BaseCrudService<UserDto, Long>{
//    UserDto findByLogin(String login);
    User findEntityById(Long id);
}
