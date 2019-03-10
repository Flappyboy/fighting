package cn.edu.nju.software.game.fighting.model.role.skill;

import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.skill.Skill;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DefaultSkillList implements SkillList, Serializable, Cloneable {
    Set<Skill> skillList = new LinkedHashSet<>();

    public DefaultSkillList clone(){
        return CloneUtils.clone( this);
    }

    @Override
    public void add(Skill skill) {
        skillList.add(skill);
    }

    @Override
    public void remove(Integer index) {
        skillList.remove(index);
    }

    @Override
    public List<Skill> getSkillList() {
        List<Skill> result = new ArrayList<>(skillList);
        return result;
    }
}
