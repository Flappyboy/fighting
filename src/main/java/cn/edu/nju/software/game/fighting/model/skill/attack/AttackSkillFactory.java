package cn.edu.nju.software.game.fighting.model.skill.attack;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

public class AttackSkillFactory extends SkillFactory {

    static List<AttackSkill> attackSkillList = new ArrayList<AttackSkill>(){{
        add(new AttackSkill(
                "普通攻击",
                new AttackAbility(),
                null,
                new PhysicalAttackStrategy()
        ));
    }};

}
