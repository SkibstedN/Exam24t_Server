package exam24t.exam24t_server.Repository;

import exam24t.exam24t_server.Model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepo extends JpaRepository<ProductOrder, Long> {
}
