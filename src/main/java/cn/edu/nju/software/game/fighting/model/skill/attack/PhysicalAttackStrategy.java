package cn.edu.nju.software.game.fighting.model.skill.attack;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.role.Role;

import java.io.Serializable;

public class PhysicalAttackStrategy implements AttackStrategy, Serializable {
    @Override
    public AttackAbility caculateAttack(Role role, AttackSkill attackSkill) {
        return attackSkill.getAttackAbility().clone().attachAbility(role.getAttackAbility()).attachAbility(role.getEquipmentList().calculateAttackAbility());
    }
}
