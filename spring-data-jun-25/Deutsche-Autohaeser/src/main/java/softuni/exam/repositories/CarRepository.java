package softuni.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.entities.Car;
import softuni.exam.models.entity.CarType;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c from Car as c where c.carType= :carType and c.mileage < :mileage order by c.mileage desc")
    List<Car> findExportable(CarType type, int mileage);
}
