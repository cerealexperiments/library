package alatoo.edu.library.dao;

import alatoo.edu.library.models.entities.Penalty;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PenaltyRepo extends JpaRepository<Penalty,Long> {
}
