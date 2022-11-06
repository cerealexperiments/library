package alatoo.edu.library.models.input_dtos;

import alatoo.edu.library.models.dto.AuthorDto;
import alatoo.edu.library.models.enums.BookGenre;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class InputBookDto {
    private String name;
    private LocalDateTime publishing_date;
    private String authorName;
    private double price;
    private BookGenre genre;
    private String imageUrl;
}
