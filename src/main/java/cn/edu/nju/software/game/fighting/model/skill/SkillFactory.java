package cn.edu.nju.software.game.fighting.model.skill;

import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class SkillFactory implements ISkillFactory {

    protected List<Skill> skillList = new ArrayList<>();

    protected List<ComboSkill> comboSkillList = new ArrayList<>();

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
    public List<Skill> getInitSkill() {
        List<Skill> skills = new ArrayList<>();
        skills.add(this.skillList.get(0));
        skills.add(this.skillList.get(1));
        return skills;
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

    @Override
    public List<ComboSkill> getAvalibleComboSkills(Set<Skill> skills) {
        List<ComboSkill> comboSkills = new ArrayList<>();
        for (ComboSkill comboSkill :
                comboSkillList) {
            if (comboSkill.has(skills)) {
                comboSkills.add(comboSkill);
            }
        }
        return comboSkills;
    }

    protected void add(Skill skill){
        skillList.add(skill);
    }

    protected void addCombo(ComboSkill skill){
        comboSkillList.add(skill);
    }
}
