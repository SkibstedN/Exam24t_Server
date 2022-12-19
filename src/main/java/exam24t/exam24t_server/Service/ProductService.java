package exam24t.exam24t_server.Service;

import exam24t.exam24t_server.Model.Product;
import exam24t.exam24t_server.Repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService implements IProductService{

    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Set<Product> findAll() {
        Set<Product> set = new HashSet<>();
        productRepo.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Product save(Product object) {
        return productRepo.save(object);
    }

    @Override
    public void delete(Product object) {
        productRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        productRepo.deleteById(aLong);
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return productRepo.findById(aLong);
    }
}
