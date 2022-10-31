package alatoo.edu.library.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "librarians")
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String password;
}
