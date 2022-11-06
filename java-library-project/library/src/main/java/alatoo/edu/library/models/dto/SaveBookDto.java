package alatoo.edu.library.models.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class SaveBookDto {
    private Long id;
    private ReaderDto readerDto;
    private BookDto bookDto;
    private boolean is_favourite;
}
