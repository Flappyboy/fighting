package cn.edu.nju.software.game.fighting.model.factory;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.Weapon;
import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.skill.Skill;

public interface ModeFactory {

    Player createPlayer(Player player);

    Role createRole(Role role);

    Weapon createWepon(Weapon weapon);

    Equipment createEquipment(Equipment equipment);

    Skill createSkill(Skill skill);

}
