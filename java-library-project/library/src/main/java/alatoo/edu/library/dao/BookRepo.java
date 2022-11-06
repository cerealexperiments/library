package alatoo.edu.library.dao;

import alatoo.edu.library.models.entities.Book;
import alatoo.edu.library.models.enums.BookGenre;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
}
