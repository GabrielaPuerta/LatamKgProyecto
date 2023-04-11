package co.edu.usbcali.LatamKG.repository;

import co.edu.usbcali.LatamKG.domain.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Integer> {

}
