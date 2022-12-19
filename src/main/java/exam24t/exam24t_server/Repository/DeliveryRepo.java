package exam24t.exam24t_server.Repository;

import exam24t.exam24t_server.Model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepo extends JpaRepository<Delivery, Long> {
}
