package alatoo.edu.library.models.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class PenaltyDto {
    private Long id;
    private UserDto userDto;
    private LocalDateTime penalty_date;
}
