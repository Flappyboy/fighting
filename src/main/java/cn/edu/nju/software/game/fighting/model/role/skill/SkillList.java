package cn.edu.nju.software.game.fighting.model.role.skill;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.FullEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.NoEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.skill.Skill;

import java.util.List;

public interface SkillList {

    void add(Skill skill);

    void remove(Integer index);

    List<Skill> getSkillList();
}
