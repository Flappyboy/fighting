package cn.edu.nju.software.game.fighting.model.item.equipment.weapon;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;

public class Weapon extends Equipment {
    public Weapon(String name) {
        super(name);
        setEquipmentType(EquipmentType.WEAPON);
    }
}
