package cn.edu.nju.software.game.fighting.model.skill.strategy;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.skill.AttackSkill;

public interface AttackStrategy {
    AttackAbility caculateAttack(Character character, AttackSkill attackSkill);
}
