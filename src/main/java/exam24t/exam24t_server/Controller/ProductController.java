package exam24t.exam24t_server.Controller;

import exam24t.exam24t_server.Model.Product;
import exam24t.exam24t_server.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@CrossOrigin("*")
@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/createProduct")
        public ResponseEntity<Product> createProduct(@ModelAttribute Product product){
            productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/showProducts")
        public ResponseEntity<Set<Product>> showProducts(){
            Set<Product> set = productService.findAll();
        return new ResponseEntity<>(set, HttpStatus.OK);
    }

    //Overwriter eksisterende product, hvis det ikke findes bliver der oprettet et nyt
    @PostMapping("/updateProduct")
        public ResponseEntity<Product> updateProduct(@RequestParam Long id,@RequestParam String name,
                                                 @RequestParam int price, @RequestParam int weight){
            Product product = new Product();
            product.setId(id);
            product.setName(name);
            product.setPrice(price);
            product.setWeight(weight);
            productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct")
        public ResponseEntity<String> deleteProduct(@RequestParam Long id){
            Optional<Product> productOptional = productService.findById(id);
            String msg;
            if(productOptional.isPresent()){
                productService.deleteById(id);
                msg = "Product with ID: " + id + "has been deleted.";
            }else{
                msg = "This Product-ID does not exist, nothing was deleted. Type an existing Product-ID";
            }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/findProductById")
        public ResponseEntity<Product> findProductById(@RequestParam Long id){
            Optional<Product> productOptional = productService.findById(id);
            Product product = new Product();
            if(productOptional.isPresent()){
                return new ResponseEntity<>(productOptional.get(),HttpStatus.OK);
            }else{
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
    }

    @GetMapping("/findProductByName")
    public ResponseEntity<Set<Product>> findProductByName(@RequestParam String name){
       Set<Product> set = productService.findAll();
        //Sætter alle rows ind i et set, sammenligener med input og fjerner alle der ikke er lig med input
        for (Product p: set)
              {if(!p.getName().equals(name)){
                  set.remove(p);
              }
          }
        if(set.isEmpty()){
            return new ResponseEntity<>(set, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(set, HttpStatus.OK);
        }
    }



}
