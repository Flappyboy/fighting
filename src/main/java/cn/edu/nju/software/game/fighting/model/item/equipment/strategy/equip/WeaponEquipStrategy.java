package cn.edu.nju.software.game.fighting.model.item.equipment.strategy.equip;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;
import cn.edu.nju.software.game.fighting.model.item.equipment.exection.UnmatchedEquipementType;
import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.Weapon;
import cn.edu.nju.software.game.fighting.model.role.Role;

import java.io.Serializable;

public class WeaponEquipStrategy extends BaseEquipStrategy implements Serializable {
    private static final long serialVersionUID = 7942973656762268914L;

    @Override
    public boolean canEquip(Role role, Equipment equipment) {
        if(equipment instanceof Weapon){
            Weapon weapon = (Weapon) equipment;
            return weapon.getWeaponType().isSupported(role.getProfession());
        }else{
            throw new UnmatchedEquipementType(EquipmentType.WEAPON, equipment.getEquipmentType());
        }
    }
}
