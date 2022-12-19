package exam24t.exam24t_server.Service;

import exam24t.exam24t_server.Model.ProductOrder;
import exam24t.exam24t_server.Repository.ProductOrderRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductOrderService implements IProductOrderService{

    private ProductOrderRepo productOrderRepo;

    public ProductOrderService(ProductOrderRepo productOrderRepo) {
        this.productOrderRepo = productOrderRepo;
    }

    @Override
    public Set<ProductOrder> findAll() {
        Set<ProductOrder> set = new HashSet<>();
        productOrderRepo.findAll().forEach(set::add);
        return set;
    }

    @Override
    public ProductOrder save(ProductOrder object) {
        return productOrderRepo.save(object);
    }

    @Override
    public void delete(ProductOrder object) {
        productOrderRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        productOrderRepo.deleteById(aLong);
    }

    @Override
    public Optional<ProductOrder> findById(Long aLong) {
        return productOrderRepo.findById(aLong);
    }
}
