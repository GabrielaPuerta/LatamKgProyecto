package co.edu.usbcali.LatamKG.repository;

import co.edu.usbcali.LatamKG.domain.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsientoRepository extends JpaRepository<Asiento, Integer> {
}

