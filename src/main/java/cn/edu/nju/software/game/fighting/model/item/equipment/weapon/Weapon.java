package cn.edu.nju.software.game.fighting.model.item.equipment.weapon;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;

public class Weapon extends Equipment {

    private static final long serialVersionUID = 300066516766564188L;
    WeaponType weaponType;

    public Weapon(String name) {
        super(name);
        setEquipmentType(EquipmentType.WEAPON);
    }

    public Weapon clone(){
        return CloneUtils.clone( this);
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }
}
