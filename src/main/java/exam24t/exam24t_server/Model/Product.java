package exam24t.exam24t_server.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
    private int weight;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<ProductOrder> productOrders = new HashSet<>();

}
