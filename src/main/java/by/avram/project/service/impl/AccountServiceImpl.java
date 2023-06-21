package by.avram.project.service.impl;

import by.avram.project.service.AccountService;
import by.avram.project.entity.Account;
import by.avram.project.repository.AccountRepository;
import by.avram.project.util.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<Account> findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    public List<String> changePassword(Account account) {
        List<String> errors = new ArrayList<>();
        Optional<Account> accountCheck = accountRepository.findAccountByUsername(account.getUsername());
        if(accountCheck.isPresent() && account.getPassword().equals(account.getRepPassword())){
            accountCheck.get().setPassword(passwordEncoder.getPasswordEncoder().encode(account.getPassword()));
            accountRepository.save(accountCheck.get());
        }else{
            errors.add("repPasswordError");
        }
        return errors;
    }

    @Override
    public void updateAccount(Account account) {
        Optional<Account> accountCheck = accountRepository.findAccountByUsername(account.getUsername());
        if(accountCheck.isPresent()){
            accountCheck.get().setRole(account.getRole());
            accountCheck.get().setActive(account.isActive());
            accountRepository.save(accountCheck.get());
        }
    }
}
