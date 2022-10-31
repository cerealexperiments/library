package alatoo.edu.library.models.dto;

import alatoo.edu.library.models.enums.OperationStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class BookOperationDto {
    private Long id;
    private ReaderDto readerDto;
    private BookDto bookDto;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private OperationStatus operation_status;
    private double operation_price;
}
