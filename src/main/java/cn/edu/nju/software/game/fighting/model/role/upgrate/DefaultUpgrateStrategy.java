package cn.edu.nju.software.game.fighting.model.role.upgrate;

import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.role.exceptions.CannotLearnException;
import cn.edu.nju.software.game.fighting.model.skill.attack.AttackSkill;
import cn.edu.nju.software.game.fighting.model.skill.attack.AttackSkillFactory;
import org.apache.commons.lang3.RandomUtils;

import java.io.Serializable;

public class DefaultUpgrateStrategy implements UpgrateStrategy, Serializable {

    private int baseExp = 70;

    @Override
    public void upgrate(Role role, int incrementExp) {
        if(incrementExp<0){
            return;
        }
        if(role instanceof Player) {
            role.say("获得经验值： " + incrementExp);
        }

        int fullExp = role.getLevel() * baseExp;
        role.setExp(role.getExp()+incrementExp);
        while(role.getExp() >= fullExp){
            role.setLevel(role.getLevel()+1);

            role.setExp(role.getExp() - fullExp);
            fullExp = role.getLevel() * baseExp;

            role.getAttackAbility().addPhysical(5*role.getLevel()+ RandomUtils.nextInt(1,3)*role.getLevel());
            role.getDefenseAbility().addPhysical(5*role.getLevel()+ RandomUtils.nextInt(1,3)*role.getLevel());
            role.setBloodMax(role.getBloodMax()+ role.getLevel() * 10);
            role.setBlood(role.getBloodMax());
            if(role instanceof Player) {
                role.say(role.getName() + " 升级了\n" + role.getDesc());
                role.say(role.getName() + " 回满了血！！ 并且上限提高！！");
            }
            for(int i=0; i<10; i++){
                try {
                    role.learnSkill(AttackSkillFactory.getInstance().randomSkill(role.getProfession()));
                    break;
                } catch (CannotLearnException e) {
                    try {
                        role.learnSkill(AttackSkillFactory.getInstance().randomSkill(Profession.NONE));
                        break;
                    } catch (CannotLearnException e1) {

                    }
                }
            }
        }
    }
}
