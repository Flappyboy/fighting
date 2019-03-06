package cn.edu.nju.software.game.fighting.model.role.bag;

import cn.edu.nju.software.game.fighting.model.item.Item;

import java.util.Iterator;

public interface Bag {

    void add(Item item);

    void remove(Item item);

    Iterator<Item> iterator();

    void sort();
}
