package cn.edu.nju.software.game.fighting.model.item.equipment.strategy.equip;

import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;

public interface IEquipStrategy {

    String getName();

    void equip(Role role, Equipment equipment);

}
