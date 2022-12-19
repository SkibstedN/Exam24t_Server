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
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deliveryDate;
    private String fromWarehouse;
    private String destination;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "delivery")
    private Set<ProductOrder> productOrders = new HashSet<>();
}
