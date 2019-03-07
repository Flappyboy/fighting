package cn.edu.nju.software.game.fighting.model.role.equipment;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.FullEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.NoEquipmentTypeException;

import java.util.List;

public interface EquipmentList {

    void add(Equipment equipment) throws FullEquipmentTypeException, NoEquipmentTypeException;

    Equipment remove(Integer equipmentTypeIndex);

    List<EquipmentType> getEquipmentTypeList();

    List<Equipment> getEquipment(EquipmentType equipmentType);
}
