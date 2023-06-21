package by.avram.project.repository;

import by.avram.project.entity.Project;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends BaseRepository<Project> {
    Optional<Project> findProjectById(Long id);
}
