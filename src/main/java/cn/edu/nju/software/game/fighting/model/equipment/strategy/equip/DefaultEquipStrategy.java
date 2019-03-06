package cn.edu.nju.software.game.fighting.model.equipment.strategy.equip;

import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.equipment.Equipment;

public class DefaultEquipStrategy implements IEquipStrategy {
    @Override
    public String getName() {
        return "默认";
    }

    @Override
    public void equip(Role role, Equipment equipment) {

    }


}
