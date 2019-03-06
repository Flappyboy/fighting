package cn.edu.nju.software.game.fighting.model.skill.attack;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.role.Role;

public class PhysicalAttackStrategy implements AttackStrategy{
    @Override
    public AttackAbility caculateAttack(Role role, AttackSkill attackSkill) {
        return attackSkill.getAttackAbility();
    }
}
