package by.avram.project.repository;

import by.avram.project.entity.Finance;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceRepository extends BaseRepository<Finance> {
    Finance findFinanceByUserId(Long id);
}
