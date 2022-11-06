package alatoo.edu.library.models.entities;

import alatoo.edu.library.models.enums.BookGenre;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDateTime publishing_date;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private double price;
    @Enumerated(EnumType.STRING)
    private BookGenre genre;
}
