package co.edu.usbcali.LatamKG.repository;

import co.edu.usbcali.LatamKG.domain.TipoAsiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAsientoRepository extends JpaRepository<TipoAsiento, Integer> {
}
