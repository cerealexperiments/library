package alatoo.edu.library.models.dto;

import alatoo.edu.library.models.entities.Author;
import alatoo.edu.library.models.enums.BookGenre;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
public class BookDto {
    private Long id;
    private String name;
    private LocalDateTime publishing_date;
    private AuthorDto authorDto;
    private double price;
    private BookGenre genre;
}
