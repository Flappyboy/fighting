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

    private AllSkillFactory() {
        skillList.addAll(AttackSkillFactory.getInstance().getSkillList());
    }
}
