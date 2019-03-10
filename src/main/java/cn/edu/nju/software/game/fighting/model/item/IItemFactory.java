package cn.edu.nju.software.game.fighting.model.item;

import java.util.List;

public interface IItemFactory {

    Item getRandomItem();

    List<Item> getAllItems();
}
