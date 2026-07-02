package niccolosciucco.u5_w1_d4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "elementi_menu")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Item {
    @Column(nullable = false)
    protected int calories;
    @Column(nullable = false)
    protected double price;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public Item() {
    }

    public Item(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", calories=" + calories +
                ", price=" + price +
                '}';
    }
}
