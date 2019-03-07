package cn.edu.nju.software.game.fighting.model.item;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.ability.SpecificAbility;

public abstract class AbilityItem extends Item{

    private AttackAbility attackAbility;

    private DefenseAbility defenseAbility;

    private SpecificAbility specificAbility;

    public AbilityItem(String name) {
        super(name);
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
}
