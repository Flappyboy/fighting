package cn.edu.nju.software.game.fighting.model.role.upgrate;

import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.exceptions.CannotLearnException;
import cn.edu.nju.software.game.fighting.model.skill.attack.AttackSkill;
import cn.edu.nju.software.game.fighting.model.skill.attack.AttackSkillFactory;
import org.apache.commons.lang3.RandomUtils;

import java.io.Serializable;

public class DefaultUpgrateStrategy implements UpgrateStrategy, Serializable {

    private int baseExp = 10;

    @Override
    public void upgrate(Role role, int incrementExp) {
        if(incrementExp<0){
            return;
        }

        role.say("获得经验值： "+incrementExp);

        int fullExp = role.getLevel() * baseExp;
        role.setExp(role.getExp()+incrementExp);
        while(role.getExp() >= fullExp){
            role.setLevel(role.getLevel()+1);

            role.setExp(role.getExp() - fullExp);
            fullExp = role.getLevel() * baseExp;

            role.getAttackAbility().addPhysical(3*role.getLevel()+ RandomUtils.nextInt(1,5));
            role.say(role.getName()+" 升级了 "+ role.getDesc());
            for(int i=0; i<10; i++){
                try {
                    role.learnSkill(AttackSkillFactory.getInstance().randomSkill(role.getProfession()));
                    break;
                } catch (CannotLearnException e) {

                }
            }
        }
    }
}
