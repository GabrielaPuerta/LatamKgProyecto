package co.edu.usbcali.LatamKG.repository;

import co.edu.usbcali.LatamKG.domain.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Integer> {

}
