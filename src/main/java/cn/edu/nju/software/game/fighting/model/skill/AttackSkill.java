package cn.edu.nju.software.game.fighting.model.skill;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.skill.strategy.AttackStrategy;


public class AttackSkill extends Skill{
    AttackAbility attackAbility;

    //策略模式
    AttackStrategy attackStrategy;

    public AttackSkill(String name, AttackAbility attackAbility, AttackStrategy attackStrategy) {
        this.name = name;
        this.attackAbility = attackAbility;
        this.attackStrategy = attackStrategy;
    }
}
