package sofuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sofuni.exam.models.entity.Moon;

//ToDo:
@Repository
public interface MoonRepository extends JpaRepository<Moon, Long> {

}
