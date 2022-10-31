package alatoo.edu.library.dao;

import alatoo.edu.library.models.entities.BookOperation;
import alatoo.edu.library.models.enums.OperationStatus;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface BookOperationRepo extends JpaRepository<BookOperation,Long> {
}
