package co.edu.usbcali.LatamKG.repository;

import co.edu.usbcali.LatamKG.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
