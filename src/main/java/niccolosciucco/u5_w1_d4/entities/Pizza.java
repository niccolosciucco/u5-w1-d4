package niccolosciucco.u5_w1_d4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "pizze")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Pizza extends Item {
    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "pizza_toppings",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppingList;

    @Column(name = "is_xl", nullable = false)
    private boolean isXl = false;

    public Pizza(String name, List<Topping> toppingList, boolean isXl) {
        super(1012, 4.3);
        this.name = name;
        this.toppingList = toppingList;
        this.isXl = isXl;
        this.calories = setCalories(toppingList, isXl);
        this.price = setPrice(toppingList, isXl);
    }

    public int setCalories(List<Topping> toppingList, boolean isXl) {
        int tot = 1012;
        if (toppingList != null) {
            for (int i = 0; i < toppingList.size(); i++) {
                tot += toppingList.get(i).getCalories();
            }
        }
        if (isXl) return tot + ((tot * 5) / 100);
        else return tot;
    }

    public double setPrice(List<Topping> t, boolean isXl) {
        double tot = 4.30;
        if (t != null) {
            for (int i = 0; i < t.size(); i++) {
                tot += t.get(i).getPrice();
            }
        }
        if (isXl) return tot + ((tot * 10) / 100);
        else return tot;
    }
}