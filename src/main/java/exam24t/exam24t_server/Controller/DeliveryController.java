package exam24t.exam24t_server.Controller;

import exam24t.exam24t_server.Model.Delivery;
import exam24t.exam24t_server.Model.Product;
import exam24t.exam24t_server.Service.DeliveryService;
import exam24t.exam24t_server.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
public class DeliveryController {

    private DeliveryService deliveryService;
    private ProductService productService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/createDelivery")
        public ResponseEntity<Delivery> createDelivery(@ModelAttribute Delivery delivery){
            deliveryService.save(delivery);
        return new ResponseEntity<>(delivery, HttpStatus.OK);
    }


}
