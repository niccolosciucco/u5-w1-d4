package niccolosciucco.u5_w1_d4.runners;

import niccolosciucco.u5_w1_d4.entities.Drink;
import niccolosciucco.u5_w1_d4.entities.Item;
import niccolosciucco.u5_w1_d4.entities.Pizza;
import niccolosciucco.u5_w1_d4.entities.Topping;
import niccolosciucco.u5_w1_d4.services.ItemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    private final ItemService itemService;

    public Runner(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //region drink
        Drink lemonade = new Drink("lemonade", 128, 1.29);
        Drink water = new Drink("water", 0, 1.29);
        Drink wine = new Drink("wine", 607, 7.49);

        itemService.save(lemonade);
        itemService.save(water);
        itemService.save(wine);
        //endregion

        //region toppings
        Topping tCheese = new Topping("cheese", 92, 0.69);
        Topping tTomato = new Topping("tomato", 92, 0.69);
        Topping tHam = new Topping("ham", 92, 0.99);
        Topping tOnions = new Topping("onions", 35, 0.69);
        Topping tPineapple = new Topping("pineapple", 24, 0.79);
        Topping tSalami = new Topping("salami", 24, 0.99);

        itemService.save(tCheese);
        itemService.save(tTomato);
        itemService.save(tHam);
        itemService.save(tOnions);
        itemService.save(tPineapple);
        itemService.save(tSalami);

        Topping cheese = (Topping) itemService.findById(tCheese.getId());
        Topping tomato = (Topping) itemService.findById(tTomato.getId());
        Topping ham = (Topping) itemService.findById(tHam.getId());
        Topping onions = (Topping) itemService.findById(tOnions.getId());
        Topping pineapple = (Topping) itemService.findById(tPineapple.getId());
        Topping salami = (Topping) itemService.findById(tSalami.getId());
        //endregion

        //region pizza
        List<Topping> margheritaToppings = List.of(tomato, cheese);
        Pizza margherita = new Pizza("margherita", margheritaToppings, false);

        List<Topping> hawaiianToppings = List.of(tomato, cheese, ham, pineapple);
        Pizza hawaiianXl = new Pizza("Hawaiian XL", hawaiianToppings, true);

        List<Topping> salamiToppings = List.of(tomato, cheese, salami);
        Pizza salamiPizza = new Pizza("salami", salamiToppings, false);

        itemService.save(margherita);
        itemService.save(hawaiianXl);
        itemService.save(salamiPizza);
        //endregion

        //region queries
        List<Item> cal = this.itemService.findByCaloriesGreaterThan(100);
        System.out.println(cal);
        List<Item> price = this.itemService.findByPriceLessThan(5.0);
        System.out.println(price);
        //endregion
    }
}