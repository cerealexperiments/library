package alatoo.edu.library.models.dto;

import alatoo.edu.library.models.enums.OperationStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class BookOperationDto {
    private Long id;
    private UserDto userDto;
    private BookDto bookDto;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private OperationStatus operationStatus;
    private double operation_price;
}
