package cn.edu.nju.software.game.fighting.model.skill.strategy.upgrate;


import cn.edu.nju.software.game.fighting.model.skill.Skill;

public class DefaultUpgrateStrategy implements UpgrateStrategy {
    int baseExp = 10;

    @Override
    public void upgrate(Skill skill, int incrementExp) {
        int currentExp = skill.getExp();
        int currentLevel =  skill.getLevel();

        int fullExp = currentLevel * baseExp;

        currentExp+=incrementExp;
        if(currentExp >= fullExp){
            skill.setLevel(currentLevel+1);
            skill.setExp(currentExp - fullExp);
        }
    }
}
