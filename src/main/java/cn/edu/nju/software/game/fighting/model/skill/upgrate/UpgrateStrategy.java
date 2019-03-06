package cn.edu.nju.software.game.fighting.model.skill.upgrate;

import cn.edu.nju.software.game.fighting.model.skill.Skill;

public interface UpgrateStrategy {

    void upgrate(Skill skill, int incrementExp);
}
