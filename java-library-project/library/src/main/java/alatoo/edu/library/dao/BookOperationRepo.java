package alatoo.edu.library.dao;

import alatoo.edu.library.models.entities.Book;
import alatoo.edu.library.models.entities.BookOperation;
import alatoo.edu.library.models.enums.OperationStatus;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookOperationRepo extends JpaRepository<BookOperation,Long> {
    BookOperation findByBookAndOperationStatus(Book book, OperationStatus operationStatus);
    List<Book> findBookByOperationStatus(OperationStatus operationStatus);
}
