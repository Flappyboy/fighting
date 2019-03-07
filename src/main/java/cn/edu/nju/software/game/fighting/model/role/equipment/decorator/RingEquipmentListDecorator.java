package cn.edu.nju.software.game.fighting.model.role.equipment.decorator;

import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;
import cn.edu.nju.software.game.fighting.model.role.equipment.EquipmentList;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;

public class RingEquipmentListDecorator extends EquipmentListDecorator {

    public RingEquipmentListDecorator(EquipmentList equipmentList) {
        super(equipmentList);
        this.equipmentType = EquipmentType.RING;
    }

    public RingEquipmentListDecorator clone(){
        return CloneUtils.clone( this);
    }
}
