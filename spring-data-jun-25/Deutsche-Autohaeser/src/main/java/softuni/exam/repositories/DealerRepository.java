package softuni.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.entities.Dealer;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
