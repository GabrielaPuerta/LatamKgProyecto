package co.edu.usbcali.LatamKG.repository;

import co.edu.usbcali.LatamKG.domain.Trayecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrayectoRepository extends JpaRepository<Trayecto, Integer> {
}
