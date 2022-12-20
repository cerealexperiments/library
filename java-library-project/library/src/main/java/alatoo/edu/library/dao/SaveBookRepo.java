package alatoo.edu.library.dao;

import alatoo.edu.library.models.entities.Book;
import alatoo.edu.library.models.entities.Reader;
import alatoo.edu.library.models.entities.SaveBook;
import alatoo.edu.library.models.entities.User;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaveBookRepo extends JpaRepository<SaveBook,Long> {
    List<SaveBook> findByUserAndIsRead(User user, boolean isRead);
    List<SaveBook> findByUserAndIsFavourite(User user, boolean isFavourite);
    SaveBook findDistinctByBookAndUser(Book book, User user);
}
