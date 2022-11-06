package alatoo.edu.library.models.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class PenaltyDto {
    private Long id;
    private ReaderDto readerDto;
    private LocalDateTime penalty_date;
}
