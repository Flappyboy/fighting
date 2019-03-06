package cn.edu.nju.software.game.fighting.model.equipment.strategy.equip;

import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.equipment.Equipment;

public interface IEquipStrategy {

    String getName();

    void equip(Role role, Equipment equipment);

}
