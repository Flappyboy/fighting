package cn.edu.nju.software.game.fighting.model.item.equipment.strategy.intensify;

import cn.edu.nju.software.game.fighting.model.item.Item;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.Weapon;

public interface IIntensifyStrategy {

    void intensify(Equipment target, Item ...items);

    void canIntensify(Equipment target, Item ...items);
}
