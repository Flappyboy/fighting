package cn.edu.nju.software.game.fighting.model.item.equipment;

import cn.edu.nju.software.game.fighting.model.item.AbilityItem;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.item.equipment.strategy.equip.IEquipStrategy;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.FullEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.NoEquipmentTypeException;

public class Equipment extends AbilityItem {

    private static final long serialVersionUID = -3058807893771797082L;
    private EquipmentType equipmentType;

    private Profession profession;

    private IEquipStrategy equipStrategy;

    public Equipment(String name) {
        super(name);
    }

    public void mount(Role role) throws NoEquipmentTypeException, FullEquipmentTypeException {
        getEquipStrategy().equip(role, this);
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public IEquipStrategy getEquipStrategy() {
        return equipStrategy;
    }

    public void setEquipStrategy(IEquipStrategy equipStrategy) {
        this.equipStrategy = equipStrategy;
    }
}
