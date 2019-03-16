package cn.edu.nju.software.game.fighting.model.skill;

import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class ComboSkill extends Skill{
    protected Set<Skill> skills = new HashSet<>();

    public ComboSkill(String name, Skill... skills) {
        super(name, Profession.NONE);
        this.skills.addAll(Arrays.asList(skills));
    }

    @Override
    public void intensify(int point) {
        int avgPoint = Math.max(point/skills.size(), 1);
        for(Skill skill: skills){
            skill.intensify(avgPoint);
        }
    }

    public boolean has(Set<Skill> skills){
        if(skills.containsAll(this.skills)){
            return true;
        }
        return false;
    }
}
