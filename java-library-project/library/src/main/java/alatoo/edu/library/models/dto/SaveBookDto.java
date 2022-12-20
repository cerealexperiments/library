package alatoo.edu.library.models.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class SaveBookDto {
    private Long id;
    private UserDto userDto;
    private BookDto bookDto;
    private boolean isFavourite;
    private boolean isRead;
}
