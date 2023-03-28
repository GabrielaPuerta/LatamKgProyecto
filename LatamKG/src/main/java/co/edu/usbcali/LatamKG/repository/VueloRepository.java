package co.edu.usbcali.LatamKG.repository;

import co.edu.usbcali.LatamKG.domain.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
}
