package cn.edu.nju.software.game.fighting.model.item.equipment.strategy.equip;

import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.FullEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.NoEquipmentTypeException;

public class DefaultEquipStrategy extends BaseEquipStrategy {


    @Override
    public boolean canEquip(Role role, Equipment equipment) {
        return true;
    }
}
