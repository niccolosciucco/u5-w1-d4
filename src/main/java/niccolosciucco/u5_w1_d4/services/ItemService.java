package niccolosciucco.u5_w1_d4.services;

import niccolosciucco.u5_w1_d4.entities.Item;
import niccolosciucco.u5_w1_d4.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void save(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("L'elemento del menu non può essere nullo");
        }
        if (item.getPrice() <= 0) {
            throw new IllegalArgumentException("Il prezzo deve essere maggiore di zero");
        }
        if (item.getCalories() < 0) {
            throw new IllegalArgumentException("Le calorie non possono essere negative");
        }
        this.itemRepository.save(item);
    }

    public Item findById(UUID id) {
        return this.itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id non presente"));
    }

    public List<Item> findByPriceLessThan(double maxPrice) {
        return this.itemRepository.findByPriceLessThan(maxPrice);
    }

    public List<Item> findByCaloriesGreaterThan(int minCalories) {
        return this.itemRepository.findByCaloriesGreaterThan(minCalories);
    }
}
