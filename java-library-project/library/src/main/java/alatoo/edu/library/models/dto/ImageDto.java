package alatoo.edu.library.models.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class ImageDto {
    private Long id;
    private String url;
    private BookDto bookDto;
}
