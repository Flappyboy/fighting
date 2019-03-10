package cn.edu.nju.software.game.fighting.model.skill;

import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class SkillFactory implements ISkillFactory {

    protected List<Skill> skillList = new ArrayList<>();

    @Override
    public Skill randomSkill() {
        return skillList.get(RandomUtils.nextInt(0,skillList.size())).clone();
    }

    @Override
    public Skill randomSkill(Profession profession) {
        List<Skill> professionList = getSkillList(profession);
        return professionList.get(RandomUtils.nextInt(0,professionList.size())).clone();
    }

    @Override
    public List<Skill> getSkillList(){
        return skillList;
    }

    @Override
    public List<Skill> getSkillList(Profession profession){
        List<Skill> list = new ArrayList<>();
        for (Skill skill:
                getSkillList()) {
            if(skill.getProfession().equals(profession)){
                list.add(skill);
            }
        }
        return list;
    }

    protected void add(Skill skill){
        skillList.add(skill);
    }
}
