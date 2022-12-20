package alatoo.edu.library.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private double money;
}