package cn.edu.nju.software.game.fighting.model.item.equipment.weapon;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;
import cn.edu.nju.software.game.fighting.model.item.equipment.strategy.equip.WeaponEquipStrategy;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;

public class Weapon extends Equipment {

    private static final long serialVersionUID = 300066516766564188L;
    WeaponType weaponType;

    public Weapon(String name, WeaponType weaponType) {
        super(name, EquipmentType.WEAPON);
        this.weaponType = weaponType;
        this.setEquipStrategy(new WeaponEquipStrategy());
    }

    @Override
    public String getDesc() {
        return weaponType.getName()+super.getDesc();
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
