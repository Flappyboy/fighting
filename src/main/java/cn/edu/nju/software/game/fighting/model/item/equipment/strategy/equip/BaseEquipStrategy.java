package cn.edu.nju.software.game.fighting.model.item.equipment.strategy.equip;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.exection.CannotEquipmentException;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.FullEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.NoEquipmentTypeException;

import java.io.Serializable;

public class BaseEquipStrategy implements IEquipStrategy, Serializable {
    private static final long serialVersionUID = -9213383153072807113L;

    @Override
    public boolean canEquip(Role role, Equipment equipment) {
        return true;
    }
    @Override
    public void equip(Role role, Equipment equipment) throws NoEquipmentTypeException, FullEquipmentTypeException, CannotEquipmentException {
        if (canEquip(role, equipment)) {
            role.getEquipmentList().add(equipment);
            role.say(role.getName() + " 成功装备 " + equipment.getName());
        } else {
            throw new CannotEquipmentException();
        }
    }
}
