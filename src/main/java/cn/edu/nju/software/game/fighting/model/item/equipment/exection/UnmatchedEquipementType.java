package cn.edu.nju.software.game.fighting.model.item.equipment.exection;

import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;

public class UnmatchedEquipementType extends RuntimeException {
    public UnmatchedEquipementType(EquipmentType expected, EquipmentType actual) {
        super("装备类型不匹配 需要："+expected.getName()+" 而不是："+actual.getName());
    }
}
