package cn.edu.nju.software.game.fighting.model.skill.attack;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.SpecificAbility;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.skill.Skill;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;

public class AttackSkill extends Skill {

    AttackAbility attackAbility;

    SpecificAbility specificAbility;

    //策略模式
    AttackStrategy attackStrategy;

    public AttackSkill(String name) {
        super(name);
    }

    public AttackSkill(String name, AttackAbility attackAbility, SpecificAbility specificAbility, AttackStrategy attackStrategy) {
        super(name);
        this.attackAbility = attackAbility;
        this.specificAbility = specificAbility;
        this.attackStrategy = attackStrategy;
    }

    public AttackSkill clone(){
        return CloneUtils.clone( this);
    }

    @Override
    public void performs(Game game, Role initiator, Role receiver) {

    }

    public AttackAbility getAttackAbility() {
        return attackAbility;
    }

    public void setAttackAbility(AttackAbility attackAbility) {
        this.attackAbility = attackAbility;
    }

    public SpecificAbility getSpecificAbility() {
        return specificAbility;
    }

    public void setSpecificAbility(SpecificAbility specificAbility) {
        this.specificAbility = specificAbility;
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }
}
