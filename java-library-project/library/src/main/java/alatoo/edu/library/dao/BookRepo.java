package alatoo.edu.library.dao;

import alatoo.edu.library.models.entities.Author;
import alatoo.edu.library.models.entities.Book;
import alatoo.edu.library.models.enums.BookGenre;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    List<Book> findByName(String name);
    List<Book> findByAuthor(Author author);
    List<Book> findByPublishingDate(int publishingDate);
}
