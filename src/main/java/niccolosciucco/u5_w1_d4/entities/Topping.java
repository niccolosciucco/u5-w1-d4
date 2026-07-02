package niccolosciucco.u5_w1_d4.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "toppings")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Topping extends Item {
    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "toppingList")
    private List<Pizza> pizzas = new ArrayList<>();

    public Topping(String name, int calories, double price) {
        super(calories, price);
        this.name = name;
    }
}