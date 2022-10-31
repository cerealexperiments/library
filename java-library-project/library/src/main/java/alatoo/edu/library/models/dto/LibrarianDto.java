package alatoo.edu.library.models.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class LibrarianDto {
    private Long id;
    private String login;
    private String password;
}
