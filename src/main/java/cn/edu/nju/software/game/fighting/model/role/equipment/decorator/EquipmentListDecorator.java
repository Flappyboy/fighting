package cn.edu.nju.software.game.fighting.model.role.equipment.decorator;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.equipment.EquipmentList;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.FullEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.NoEquipmentTypeException;

import java.util.List;

//Decorator pattern
public abstract class EquipmentListDecorator implements EquipmentList {
    protected EquipmentList equipmentList;

    public EquipmentListDecorator(EquipmentList equipmentList) {
        this.equipmentList = equipmentList;
    }

    protected EquipmentType equipmentType;
    protected Equipment equipment;

    @Override
    public void add(Role role, Equipment equipment) throws NoEquipmentTypeException, FullEquipmentTypeException {
        if(equipment.getEquipmentType().equals(equipmentType)){
            if(this.equipment == null){
                this.equipment = equipment;
                return;
            }
        }
        equipmentList.add(role, equipment);
    }

    @Override
    public void remove(Role role, Integer equipmentTypeIndex) {
        if(equipmentTypeIndex == equipmentList.getEquipmentTypeList().size()){
            role.getBag().add(this.equipment);
            this.equipment = null;
        }else if(equipmentTypeIndex < equipmentList.getEquipmentTypeList().size()){
            this.equipmentList.remove(role, equipmentTypeIndex);
        }else{
            throw new RuntimeException("WRONG: equipmentTypeIndex: "+equipmentTypeIndex);
        }
    }

    @Override
    public List<EquipmentType> getEquipmentTypeList() {
        List<EquipmentType> equipmentTypeList = this.equipmentList.getEquipmentTypeList();
        equipmentTypeList.add(this.equipmentType);
        return equipmentTypeList;
    }

    @Override
    public List<Equipment> getEquipment(EquipmentType equipmentType) {
        List<Equipment> equipmentList = this.equipmentList.getEquipment(equipmentType);
        if(this.equipmentType.equals(equipmentType)){
            equipmentList.add(this.equipment);
        }
        return equipmentList;
    }

}
