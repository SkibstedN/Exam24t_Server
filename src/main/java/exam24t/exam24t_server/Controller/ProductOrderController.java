package exam24t.exam24t_server.Controller;

import exam24t.exam24t_server.Model.Delivery;
import exam24t.exam24t_server.Model.Product;
import exam24t.exam24t_server.Model.ProductOrder;
import exam24t.exam24t_server.Service.DeliveryService;
import exam24t.exam24t_server.Service.ProductOrderService;
import exam24t.exam24t_server.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
public class ProductOrderController {

    private ProductOrderService productOrderService;
    private ProductService productService;
    private DeliveryService deliveryService;

    public ProductOrderController(ProductOrderService productOrderService, ProductService productService,
                                  DeliveryService deliveryService) {
        this.productOrderService = productOrderService;
        this.productService = productService;
        this.deliveryService = deliveryService;
    }

    @PostMapping("/createProductOrder")
    public ResponseEntity<ProductOrder> createProductOrder(@ModelAttribute ProductOrder productOrder){
        productOrderService.save(productOrder);
        return new ResponseEntity<>(productOrder, HttpStatus.OK);
    }


    @PostMapping("/addProduct")
    public ResponseEntity<ProductOrder> addProduct(@RequestParam Long productOrderId, @RequestParam Long productId){
        Optional<ProductOrder> productOrderOptional = productOrderService.findById(productOrderId);
        Optional<Product> productOptional = productService.findById(productId);

        ProductOrder productOrdervoid = new ProductOrder();

        if(productOrderOptional.isPresent()&&productOptional.isPresent()){
            ProductOrder productOrder = productOrderOptional.get();
            productOrder.setProduct(productOptional.get());
            return  new ResponseEntity<>(productOrderService.save(productOrder), HttpStatus.OK);
        }else{ return new ResponseEntity<>(productOrdervoid, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/addDelivery")
    public ResponseEntity<ProductOrder> addDelivery(@RequestParam Long productOrderId, @RequestParam Long deliveryId){
        Optional<ProductOrder> productOrderOptional = productOrderService.findById(productOrderId);
        Optional<Delivery> deliveryOptional = deliveryService.findById(deliveryId);

        ProductOrder productOrdervoid = new ProductOrder();

        if(productOrderOptional.isPresent()&&deliveryOptional.isPresent()){
            ProductOrder productOrder = productOrderOptional.get();
            productOrder.setDelivery(deliveryOptional.get());
            return new ResponseEntity<>(productOrderService.save(productOrder), HttpStatus.OK);
        }else{ return new ResponseEntity<>(productOrdervoid, HttpStatus.NOT_FOUND);
        }
    }

}
