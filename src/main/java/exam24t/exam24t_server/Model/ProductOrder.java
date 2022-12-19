package exam24t.exam24t_server.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne // many productorders can have one product
    @JsonBackReference // stops circular references in JSON output
    @EqualsAndHashCode.Exclude // leaves product out in the equals()
    // and hashCode() methods, to avoid circular reference
    private Product product;

    @ManyToOne // many productorders can have one Delivery
    @JsonBackReference(value = "deliveryvalue") // stops circular references in JSON output
    @EqualsAndHashCode.Exclude // leaves delivery out in the equals()
    // and hashCode() methods, to avoid circular reference
    private Delivery delivery;


}
