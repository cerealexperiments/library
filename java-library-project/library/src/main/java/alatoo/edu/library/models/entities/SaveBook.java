package alatoo.edu.library.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "save_books")
public class SaveBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private boolean isRead;
    private boolean isFavourite;
}
