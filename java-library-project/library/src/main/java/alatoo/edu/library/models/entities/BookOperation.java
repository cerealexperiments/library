package alatoo.edu.library.models.entities;

import alatoo.edu.library.models.enums.OperationStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "book_operations")
public class BookOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDateTime start_date;
    private LocalDateTime end_date;
    @Enumerated(EnumType.STRING)
    private OperationStatus operationStatus;
    private double operation_price;
}
