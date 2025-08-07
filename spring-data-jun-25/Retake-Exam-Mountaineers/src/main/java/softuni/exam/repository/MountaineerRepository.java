package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.enums.Mountaineer;

@Repository
public interface MountaineerRepository extends JpaRepository<Mountaineer, Long> {
}
