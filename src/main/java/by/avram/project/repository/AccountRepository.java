package by.avram.project.repository;

import by.avram.project.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends BaseRepository<Account> {
    Optional<Account> findAccountByUsername(String username);
    Optional<Account> findAccountById(Long id);
}
