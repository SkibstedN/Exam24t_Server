package exam24t.exam24t_server.Service;

import exam24t.exam24t_server.Model.Delivery;
import exam24t.exam24t_server.Repository.DeliveryRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class DeliveryService implements IDeliveryService{

    private DeliveryRepo deliveryRepo;

    public DeliveryService(DeliveryRepo deliveryRepo) {
        this.deliveryRepo = deliveryRepo;
    }

    @Override
    public Set<Delivery> findAll() {
        Set<Delivery> set = new HashSet<>();
        deliveryRepo.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Delivery save(Delivery object) {
        return deliveryRepo.save(object);
    }

    @Override
    public void delete(Delivery object) {
        deliveryRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        deliveryRepo.deleteById(aLong);
    }

    @Override
    public Optional<Delivery> findById(Long aLong) {
        return deliveryRepo.findById(aLong);
    }
}
