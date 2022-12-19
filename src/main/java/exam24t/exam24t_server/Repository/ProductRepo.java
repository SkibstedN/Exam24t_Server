package exam24t.exam24t_server.Repository;

import exam24t.exam24t_server.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
