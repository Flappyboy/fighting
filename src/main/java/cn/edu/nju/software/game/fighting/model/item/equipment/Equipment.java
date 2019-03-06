package cn.edu.nju.software.game.fighting.model.item.equipment;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.ability.SpecificAbility;
import cn.edu.nju.software.game.fighting.model.item.Item;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.item.equipment.strategy.equip.IEquipStrategy;
import cn.edu.nju.software.game.fighting.model.item.equipment.strategy.intensify.IIntensifyStrategy;

public abstract class Equipment extends Item {

    private EquipmentType equipmentType;

    private Profession profession;

    private AttackAbility attackAbility;

    private DefenseAbility defenseAbility;

    private SpecificAbility specificAbility;

    private IEquipStrategy equipStrategy;

    private IIntensifyStrategy intensifyStrategy;

    public Equipment(String name) {
        super(name);
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

    public AttackAbility getAttackAbility() {
        return attackAbility;
    }

    public void setAttackAbility(AttackAbility attackAbility) {
        this.attackAbility = attackAbility;
    }

    public DefenseAbility getDefenseAbility() {
        return defenseAbility;
    }

    public void setDefenseAbility(DefenseAbility defenseAbility) {
        this.defenseAbility = defenseAbility;
    }

    public SpecificAbility getSpecificAbility() {
        return specificAbility;
    }

    public void setSpecificAbility(SpecificAbility specificAbility) {
        this.specificAbility = specificAbility;
    }

    public IEquipStrategy getEquipStrategy() {
        return equipStrategy;
    }

    public void setEquipStrategy(IEquipStrategy equipStrategy) {
        this.equipStrategy = equipStrategy;
    }

    public IIntensifyStrategy getIntensifyStrategy() {
        return intensifyStrategy;
    }

    public void setIntensifyStrategy(IIntensifyStrategy intensifyStrategy) {
        this.intensifyStrategy = intensifyStrategy;
    }
}
