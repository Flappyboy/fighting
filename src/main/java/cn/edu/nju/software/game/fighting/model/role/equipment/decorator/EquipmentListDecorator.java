package cn.edu.nju.software.game.fighting.model.role.equipment.decorator;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.equipment.DefaultEquipmentList;
import cn.edu.nju.software.game.fighting.model.role.equipment.EquipmentList;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.FullEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.NoEquipmentTypeException;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;

import java.io.Serializable;
import java.util.List;

//Decorator pattern
public abstract class EquipmentListDecorator implements EquipmentList, Serializable {
    protected EquipmentList equipmentList;

    public EquipmentListDecorator(EquipmentList equipmentList) {
        this.equipmentList = equipmentList;
    }

    protected EquipmentType equipmentType;
    protected Equipment equipment;

    public EquipmentListDecorator clone(){
        return CloneUtils.clone( this);
    }


    @Override
    public void add(Equipment equipment) throws NoEquipmentTypeException, FullEquipmentTypeException {
        if(equipment.getEquipmentType().equals(equipmentType)){
            if(this.equipment == null){
                this.equipment = equipment;
                return;
            }
        }
        equipmentList.add(equipment);
    }

    @Override
    public Equipment remove(int equipmentTypeIndex) {
        Equipment tmp;
        if(equipmentTypeIndex == equipmentList.getEquipmentTypeList(true).size()){
            tmp = this.equipment;
            this.equipment = null;
        }else if(equipmentTypeIndex < equipmentList.getEquipmentTypeList(true).size()){
            tmp = this.equipmentList.remove(equipmentTypeIndex);
        }else{
            throw new RuntimeException("WRONG: equipmentTypeIndex: "+equipmentTypeIndex);
        }
        return tmp;
    }

    @Override
    public void remove(Equipment equipment) {
        if(this.equipment == equipment){
            this.equipment = null;
        }else{
            this.equipmentList.remove(equipment);
        }
    }

    @Override
    public Equipment getEquipment(int equipmentTypeIndex) {
        Equipment tmp = null;
        if(equipmentTypeIndex == equipmentList.getEquipmentTypeList(true).size()){
            tmp = this.equipment;
        }else if(equipmentTypeIndex < equipmentList.getEquipmentTypeList(true).size()){
            tmp = this.equipmentList.getEquipment(equipmentTypeIndex);
        }else{
            throw new RuntimeException("WRONG: equipmentTypeIndex: "+equipmentTypeIndex);
        }
        return tmp;
    }

    @Override
    public List<EquipmentType> getEquipmentTypeList(boolean all) {
        List<EquipmentType> equipmentTypeList = this.equipmentList.getEquipmentTypeList(all);
        if(!all) {
            for (EquipmentType equipmentType : equipmentTypeList) {
                if (equipmentType.equals(this.equipmentType)) {
                    return equipmentTypeList;
                }
            }
        }
        equipmentTypeList.add(this.equipmentType);
        return equipmentTypeList;
    }

    @Override
    public List<Equipment> getEquipment(EquipmentType equipmentType) {
        List<Equipment> equipmentList = this.equipmentList.getEquipment(equipmentType);
        if(this.equipmentType.equals(equipmentType) && this.equipment != null){
            equipmentList.add(this.equipment);
        }
        return equipmentList;
    }

    @Override
    public AttackAbility calculateAttackAbility() {
        AttackAbility attackAbility = this.equipmentList.calculateAttackAbility();
        attackAbility.attachAbility(this.equipment.getAttackAbility());
        return attackAbility;
    }
}
