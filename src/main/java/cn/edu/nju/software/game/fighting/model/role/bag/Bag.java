package cn.edu.nju.software.game.fighting.model.role.bag;

import cn.edu.nju.software.game.fighting.model.item.Item;
import cn.edu.nju.software.game.fighting.model.item.intensify.IntensifyMaterial;

import java.util.Iterator;
import java.util.List;

public interface Bag {

    void add(Item item);

    void remove(Item item);

    Iterator<Item> iterator();

    void sort();

    List<IntensifyMaterial> getIntensifyItem();
}
