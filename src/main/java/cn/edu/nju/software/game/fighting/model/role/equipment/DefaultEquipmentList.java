package cn.edu.nju.software.game.fighting.model.role.equipment;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.FullEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.NoEquipmentTypeException;

import java.util.ArrayList;
import java.util.List;

public class DefaultEquipmentList implements EquipmentList {
    private Equipment weapon = null;

    private Equipment helmet = null;

    private Equipment armor = null;

    @Override
    public void add(Role role, Equipment equipment) throws FullEquipmentTypeException, NoEquipmentTypeException {
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
        role.getBag().remove(equipment);
    }

    @Override
    public void remove(Role role, Integer equipmentTypeIndex) {
        Equipment demount = null;
        switch (equipmentTypeIndex){
            case 0:
                demount = weapon;
                weapon = null;
                break;
            case 1:
                demount = weapon;
                weapon = null;
                break;
            case 2:
                demount = weapon;
                weapon = null;
                break;
            default:
                throw new RuntimeException("WRONG: equipmentTypeIndex: "+equipmentTypeIndex);
        }
        role.getBag().add(demount);
    }

    @Override
    public List<EquipmentType> getEquipmentTypeList() {
        List<EquipmentType> list = new ArrayList<>();

        list.add(EquipmentType.WEAPON);
        list.add(EquipmentType.HELMET);
        list.add(EquipmentType.ARMOR);
        return list;
    }

    @Override
    public List<Equipment> getEquipment(EquipmentType equipmentType) {
        List<Equipment> list = new ArrayList<>();
        switch (equipmentType){
            case WEAPON:
                list.add(weapon);
                break;
            case HELMET:
                list.add(helmet);
                break;
            case ARMOR:
                list.add(armor);
                break;
        }
        return list;
    }
}
