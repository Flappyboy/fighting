package cn.edu.nju.software.game.fighting.model.skill;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.skill.attack.AttackSkill;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class ComboSkill extends Skill{
    private Set<Skill> skills = new HashSet<>();

    public ComboSkill(String name, Skill... skills) {
        super(name, Profession.NONE);
        this.skills.addAll(Arrays.asList(skills));
    }

    @Override
    public void performs(Game game, Role initiator, Role receiver) {
        say(initiator.getName()+" 发动了技能："+this.getName());
        for(Skill skill: skills){
            if(skill instanceof AttackSkill){
                AttackSkill attackSkill = (AttackSkill) skill;
                receiver.receiveAttack(attackSkill.getAttackStrategy().caculateAttack(initiator, attackSkill));
            }
        }
    }



    @Override
    public void intensify(int point) {
        int avgPoint = Math.max(point/skills.size(), 1);
        for(Skill skill: skills){
            skill.intensify(avgPoint);
        }
    }
}
