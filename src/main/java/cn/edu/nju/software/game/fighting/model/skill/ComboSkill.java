package cn.edu.nju.software.game.fighting.model.skill;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.skill.attack.AttackSkill;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ComboSkill extends AttackSkill{
    private Set<Skill> skills = new HashSet<>();

    public ComboSkill(String name, Skill... skills) {
        super(name, Profession.NONE);
        this.skills.addAll(Arrays.asList(skills));
    }

    @Override
    public void intensify(int point) {

    }
}
