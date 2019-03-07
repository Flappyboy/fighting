package cn.edu.nju.software.game.fighting.model.item.equipment.strategy.intensify;

import cn.edu.nju.software.game.fighting.model.item.Item;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;

public class DefaultIntensifyStrategy implements IIntensifyStrategy{

    @Override
    public void intensify(Equipment target, Item... items) {
        for (Item item: items) {
            target.getAttackAbility();
            target.getDefenseAbility();
            target.getSpecificAbility();
        }
    }

    @Override
    public void canIntensify(Equipment target, Item... items) {

    }
}
