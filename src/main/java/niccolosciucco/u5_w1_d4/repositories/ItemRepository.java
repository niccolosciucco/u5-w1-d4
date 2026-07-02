package niccolosciucco.u5_w1_d4.repositories;

import niccolosciucco.u5_w1_d4.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
    List<Item> findByPriceLessThan(double maxPrice);

    List<Item> findByCaloriesGreaterThan(int minCalories);
}
