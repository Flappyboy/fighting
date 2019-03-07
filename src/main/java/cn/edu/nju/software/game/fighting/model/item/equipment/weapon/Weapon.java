package cn.edu.nju.software.game.fighting.model.item.equipment.weapon;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;

public class Weapon extends Equipment {

    WeaponType weaponType;

    public Weapon(String name) {
        super(name);
        setEquipmentType(EquipmentType.WEAPON);
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }
}
