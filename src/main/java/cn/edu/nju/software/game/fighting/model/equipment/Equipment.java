package cn.edu.nju.software.game.fighting.model.equipment;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.ability.SpecificAbility;
import cn.edu.nju.software.game.fighting.model.role.Profession;
import cn.edu.nju.software.game.fighting.model.equipment.strategy.equip.IEquipStrategy;
import cn.edu.nju.software.game.fighting.model.equipment.strategy.intensify.IIntensifyStrategy;

public abstract class Equipment {
    private String name;

    private Profession profession;

    private AttackAbility attackAbility;

    private DefenseAbility defenseAbility;

    private SpecificAbility specificAbility;

    private IEquipStrategy equipStrategy;

    private IIntensifyStrategy intensifyStrategy;

    public Equipment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
