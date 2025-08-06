package sofuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sofuni.exam.models.entity.Moon;
import sofuni.exam.models.enums.Type;

import java.util.List;

//ToDo:
@Repository
public interface MoonRepository extends JpaRepository<Moon, Long> {
    boolean existsByName(String name);
//    select * from moons as m join planets as p on m.planet_id = p.id where p.type = 'GAS_GIANT' and m.radius between 700 and 2000 order by m.name;

//    @Query("select m from Moon m join m.planetId p where p.type = :planetType and m.radius between :radiusLower and :radiusUpper order by m.name")
    @Query("select m from Moon m where m.planetId.type = :planetType and m.radius between :radiusLower and :radiusUpper order by m.name")
    List<Moon> findExportable(Type planetType, int radiusLower, int radiusUpper);
}


//Export all moons that orbits planets of type GAS_GIANT and have radius between 700km and 2000km. from the Database
//    • Extract from the database, the moon name, the name of the planet it orbits, moon radius and moon discoverer.
//    • Filter only moons whose radius is more than or equal to 700km and equal to or less than 2000km. Order the results by moon name in ascending order.
//    • You have to round the value of the radius to the second decimal digit.
//    • Return the information in this format: