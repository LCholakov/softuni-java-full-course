package softuni.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.entities.Dealership;

@Repository
public interface DealershipRepository extends JpaRepository<Dealership, Long> {
}
