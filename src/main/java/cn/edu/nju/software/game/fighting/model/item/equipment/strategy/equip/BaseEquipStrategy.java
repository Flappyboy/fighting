package cn.edu.nju.software.game.fighting.model.item.equipment.strategy.equip;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.FullEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.NoEquipmentTypeException;

public abstract class BaseEquipStrategy implements IEquipStrategy {

    @Override
    public void equip(Role role, Equipment equipment) {
        try {
            if(canEquip(role, equipment)){
                role.getEquipmentList().add(role, equipment);
                role.getGame().say(role.getName()+" 成功装备 "+equipment.getName());
            }else{
                role.getGame().say(role.getName()+" 无法装备 "+equipment.getName());
            }
        } catch (FullEquipmentTypeException e) {
            role.getGame().say(e.getMessage());
        } catch (NoEquipmentTypeException e) {
            role.getGame().say(e.getMessage());
        }
    }
}
