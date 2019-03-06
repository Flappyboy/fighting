package cn.edu.nju.software.game.fighting.model.item.equipment.strategy.equip;

import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;

public class DefaultEquipStrategy implements IEquipStrategy {
    @Override
    public String getName() {
        return "默认";
    }

    @Override
    public void equip(Role role, Equipment equipment) {

    }


}
