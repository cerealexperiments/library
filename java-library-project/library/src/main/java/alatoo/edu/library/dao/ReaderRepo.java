package alatoo.edu.library.dao;

import alatoo.edu.library.models.entities.Reader;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepo extends JpaRepository<Reader,Long> {
}
