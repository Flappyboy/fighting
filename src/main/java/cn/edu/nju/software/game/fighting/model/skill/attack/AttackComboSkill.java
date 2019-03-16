package cn.edu.nju.software.game.fighting.model.skill.attack;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.skill.ComboSkill;
import cn.edu.nju.software.game.fighting.model.skill.Skill;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AttackComboSkill extends ComboSkill {

    public AttackComboSkill(String name, Skill... skills) {
        super(name, skills);
    }

    @Override
    public void performs(Game game, Role initiator, Role receiver) {
        say(initiator.getName()+" 发动了技能："+this.getName());
        AttackAbility attackAbility = new AttackAbility();
        for(Skill skill: skills){
            if(skill instanceof AttackSkill){
                AttackSkill attackSkill = (AttackSkill) skill;
                attackAbility.attachAbility(attackSkill.getAttackStrategy().caculateAttack(initiator, attackSkill));
            }
        }
        receiver.receiveAttack(attackAbility);
    }

    @Override
    public String getDesc() {
        String base = "";
        for (Skill skill :
                skills) {
            base+= skill.getName()+" ";
        }
        return "组合技： "+name+ "  基础技能："+ base;
    }
}
