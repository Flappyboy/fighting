package cn.edu.nju.software.game.fighting.model.item;

import java.util.List;

public interface IItemFactory {

    Item getRandomItem();

    Item getItemByName(String name);

    List<Item> getAllItems();
}
