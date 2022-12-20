package alatoo.edu.library.dao;

import alatoo.edu.library.models.entities.User;
import alatoo.edu.library.models.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Long> {
    Wallet findByUser(User user);
}
