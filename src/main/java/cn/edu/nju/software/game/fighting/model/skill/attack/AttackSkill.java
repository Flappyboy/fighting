package cn.edu.nju.software.game.fighting.model.skill.attack;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.SpecificAbility;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.skill.Skill;

public class AttackSkill extends Skill {

    AttackAbility attackAbility;

    SpecificAbility specificAbility;

    //策略模式
    AttackStrategy attackStrategy;

    public AttackSkill(String name) {
        super(name);
    }

    @Override
    public void performs(Game game, Role initiator, Role receiver) {

    }

    public AttackAbility getAttackAbility() {
        return attackAbility;
    }
}
