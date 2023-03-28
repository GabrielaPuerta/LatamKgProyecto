

package co.edu.usbcali.LatamKG.repository;

import co.edu.usbcali.LatamKG.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}
