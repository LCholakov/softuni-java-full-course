package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Mountain;

import java.util.List;

@Repository
public interface MountainRepository extends JpaRepository<Mountain, Long> {

    @Query("select m from Mountain m where m.elevation > :elevationMin and m.hardToReach = :hardToReach order by m.elevation desc")
    List<Mountain> findExportable(int elevationMin, boolean hardToReach);
}
