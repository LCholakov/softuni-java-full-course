package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.enums.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
