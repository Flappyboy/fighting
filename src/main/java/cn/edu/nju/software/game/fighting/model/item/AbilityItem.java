package cn.edu.nju.software.game.fighting.model.item;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.ability.SpecificAbility;
import cn.edu.nju.software.game.fighting.model.role.attribute.State;

public abstract class AbilityItem extends Item{

    private AttackAbility attackAbility;

    private DefenseAbility defenseAbility;

    private SpecificAbility specificAbility;

    public AbilityItem(String name) {
        super(name);
    }

    @Override
    public String getDesc() {
        String str="";
        if(getAttackAbility().getPhysical()!=0)
            str+=" 攻："+ getAttackAbility().getPhysical();
        if(getDefenseAbility().getPhysical()!=0)
            str+=" 防："+ getDefenseAbility().getPhysical();
        for(State state: State.allState()){
            if(getSpecificAbility().getAbilityValue(state)>0)
                str+="  "+getDefenseAbility().getPhysical();
        }
        return str;
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
