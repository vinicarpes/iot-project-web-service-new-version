package br.ifsc.edu.fln.iotprojectapi.repositories;

import br.ifsc.edu.fln.iotprojectapi.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    boolean existsByLatitude(float latitude);
    boolean existsByLongitude(float longitude);

}
