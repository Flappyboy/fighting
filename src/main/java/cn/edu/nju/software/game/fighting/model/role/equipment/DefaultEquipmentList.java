package cn.edu.nju.software.game.fighting.model.role.equipment;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;
import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.FullEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.NoEquipmentTypeException;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DefaultEquipmentList implements EquipmentList, Serializable, Cloneable {
    private Equipment weapon = null;

    private Equipment helmet = null;

    private Equipment armor = null;

    public DefaultEquipmentList clone(){
        return CloneUtils.clone( this);
    }

    @Override
    public void add(Equipment equipment) throws FullEquipmentTypeException, NoEquipmentTypeException {
        switch (equipment.getEquipmentType()){
            case WEAPON:
                if(weapon != null){
                    throw new FullEquipmentTypeException();
                }
                weapon = equipment;
                break;
            case HELMET:
                if(helmet != null){
                    throw new FullEquipmentTypeException();
                }
                helmet = equipment;
                break;
            case ARMOR:
                if(armor != null){
                    throw new FullEquipmentTypeException();
                }
                armor = equipment;
                break;
            default:
                throw new NoEquipmentTypeException();
        }
    }

    @Override
    public Equipment remove(int equipmentTypeIndex) {
        Equipment demount = null;
        switch (equipmentTypeIndex){
            case 0:
                demount = weapon;
                weapon = null;
                break;
            case 1:
                demount = helmet;
                helmet = null;
                break;
            case 2:
                demount = armor;
                armor = null;
                break;
            default:
                throw new RuntimeException("WRONG: equipmentTypeIndex: "+equipmentTypeIndex);
        }
        return demount;
    }

    @Override
    public void remove(Equipment equipment) {
        if(equipment == this.weapon){
            this.weapon = null;
        }else if(equipment == this.helmet){
            this.helmet = null;
        }else if(equipment == this.armor){
            this.armor = null;
        }else{
            throw new RuntimeException("错误的删除装备："+equipment.getDesc());
        }
    }
    @Override
    public Equipment getEquipment(int equipmentTypeIndex) {
        Equipment demount = null;
        switch (equipmentTypeIndex){
            case 0:
                demount = weapon;
                break;
            case 1:
                demount = helmet;
                break;
            case 2:
                demount = armor;
                break;
            default:
                throw new RuntimeException("WRONG: equipmentTypeIndex: "+equipmentTypeIndex);
        }
        return demount;
    }

    @Override
    public List<EquipmentType> getEquipmentTypeList(boolean all) {
        List<EquipmentType> list = new ArrayList<>();
        list.add(EquipmentType.WEAPON);
        list.add(EquipmentType.HELMET);
        list.add(EquipmentType.ARMOR);
        return list;
    }

    @Override
    public List<Equipment> getEquipment(EquipmentType equipmentType) {
        List<Equipment> list = new ArrayList<>();
        Equipment equipment = null;
        switch (equipmentType){
            case WEAPON:
                equipment = weapon;
                break;
            case HELMET:
                equipment = helmet;
                break;
            case ARMOR:
                equipment = armor;
                break;
        }
        if(equipment != null)
            list.add(equipment);
        return list;
    }

    @Override
    public AttackAbility calculateAttackAbility() {
        AttackAbility attackAbility = new AttackAbility();
        if(weapon != null){
            attackAbility.attachAbility(weapon.getAttackAbility());
        }
        if(helmet != null){
            attackAbility.attachAbility(helmet.getAttackAbility());
        }
        if(armor != null){
            attackAbility.attachAbility(armor.getAttackAbility());
        }
        return attackAbility;
    }
}
