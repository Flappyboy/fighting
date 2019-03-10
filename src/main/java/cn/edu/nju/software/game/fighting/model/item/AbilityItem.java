package cn.edu.nju.software.game.fighting.model.item;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.ability.RecoveryAbility;
import cn.edu.nju.software.game.fighting.model.ability.SpecificAbility;
import cn.edu.nju.software.game.fighting.model.role.attribute.State;

public abstract class AbilityItem extends Item{

    private AttackAbility attackAbility = new AttackAbility();

    private DefenseAbility defenseAbility = new DefenseAbility();

    private SpecificAbility specificAbility = new SpecificAbility();

    private RecoveryAbility recoveryAbility = new RecoveryAbility();

    public AbilityItem(String name) {
        super(name);
    }

    @Override
    public String getDesc() {
        String str= super.getDesc();
        if(getAttackAbility().getPhysical()!=0)
            str+=" 攻："+ getAttackAbility().getPhysical();
        if(getDefenseAbility().getPhysical()!=0)
            str+=" 防："+ getDefenseAbility().getPhysical();
        if(getRecoveryAbility().getBlood()!=0)
            str+=" 恢复："+ getRecoveryAbility().getBlood();
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

    public RecoveryAbility getRecoveryAbility() {
        return recoveryAbility;
    }

    public void setRecoveryAbility(RecoveryAbility recoveryAbility) {
        this.recoveryAbility = recoveryAbility;
    }
}
