package by.avram.project.service;

import by.avram.project.entity.FinanceHistory;
import by.avram.project.entity.User;
import by.avram.project.entity.Finance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FinanceService extends BaseService<Finance>{
    void updateFinance(Finance finance);
    void transaction(FinanceHistory financeHistory, Long id);
    double userSalary(Finance finance);
    Optional<Finance> findUserFinance(Long id);
    Optional<User> findUserFinanceByUsername(String username);
    Page<FinanceHistory> findAllFinanceHistory(Pageable pageable);
    Page<FinanceHistory> findUserFinanceHistoryById(Long id, Pageable pageable);
    Page<User> findAllUserFinance(Pageable pageable);
}
