package cn.edu.nju.software.game.fighting.model.skill;

import cn.edu.nju.software.game.fighting.model.skill.attack.AttackSkillFactory;

public class AllSkillFactory extends SkillFactory {

    private static AllSkillFactory instance;

    public static AllSkillFactory getInstance(){
        if (instance == null) {
            instance = new AllSkillFactory();
        }
        return instance;
    }

    public AllSkillFactory() {
        skillList.addAll(new AttackSkillFactory().getSkillList());
    }
}
