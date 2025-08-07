package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Mountain;

@Repository
public interface MountainRepository extends JpaRepository<Mountain, Long> {
}
