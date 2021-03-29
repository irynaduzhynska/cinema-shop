package cinema.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "shopping_cart_id")
    private User user;
    @OneToMany
    @JoinTable(name = "shopping_carts_tickets",
            joinColumns =
            @JoinColumn(name = "shopping_cart_id"),
            inverseJoinColumns =
            @JoinColumn(name = "ticket_id"))
    private List<Ticket> tickets;
}
