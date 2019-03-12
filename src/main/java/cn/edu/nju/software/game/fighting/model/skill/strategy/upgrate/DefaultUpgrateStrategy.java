package cn.edu.nju.software.game.fighting.model.skill.strategy.upgrate;


import cn.edu.nju.software.game.fighting.model.skill.Skill;
import cn.edu.nju.software.game.fighting.model.skill.attack.AttackSkill;

import java.io.Serializable;

public class DefaultUpgrateStrategy implements UpgrateStrategy, Serializable {
    int baseExp = 20;

    @Override
    public void upgrate(Skill skill, int incrementExp) {
        if(incrementExp<0){
            return;
        }
        int fullExp = skill.getLevel() * baseExp;
        skill.setExp(skill.getExp()+incrementExp);
        while(skill.getExp() >= fullExp){
            skill.setLevel(skill.getLevel()+1);

            skill.setExp(skill.getExp() - fullExp);

            fullExp = skill.getLevel() * baseExp;
            skill.intensify(skill.getLevel());
            skill.say("技能 "+skill.getName()+" 升级了！" + skill.getDesc());
        }
    }
}
