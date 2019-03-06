package cn.edu.nju.software.game.fighting.model.role.upgrate;

import cn.edu.nju.software.game.fighting.model.role.Role;

public class DefaultUpgrateStrategy implements UpgrateStrategy{

    private int baseExp = 10;

    @Override
    public void upgrate(Role role, int incrementExp) {
        int currentExp = role.getExp();
        int currentLevel =  role.getLevel();

        int fullExp = currentLevel*baseExp;

        currentExp+=incrementExp;
        if(currentExp>=fullExp){
            role.setLevel(currentLevel+1);
            role.setExp(currentExp - fullExp);
        }
    }
}
