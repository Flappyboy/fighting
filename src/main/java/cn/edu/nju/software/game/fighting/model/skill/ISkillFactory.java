package cn.edu.nju.software.game.fighting.model.skill;

import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.skill.attack.AttackSkill;

import java.util.List;
import java.util.Set;

public interface ISkillFactory {

    Skill randomSkill();

    Skill randomSkill(Profession profession);

    List<Skill> getSkillList();

    List<Skill> getSkillList(Profession profession);

    List<ComboSkill> getAvalibleComboSkills(Set<Skill> skills);

    List<Skill> getInitSkill();
}
