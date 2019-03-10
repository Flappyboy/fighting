package cn.edu.nju.software.game.fighting.model.role.equipment;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.FullEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.NoEquipmentTypeException;

import java.util.List;

public interface EquipmentList {

    void add(Equipment equipment) throws FullEquipmentTypeException, NoEquipmentTypeException;

    Equipment remove(int equipmentTypeIndex);

    void remove(Equipment equipment);

    List<EquipmentType> getEquipmentTypeList(boolean all);

    List<Equipment> getEquipment(EquipmentType equipmentType);

    Equipment getEquipment(int equipmentTypeIndex);

    AttackAbility calculateAttackAbility();
}
