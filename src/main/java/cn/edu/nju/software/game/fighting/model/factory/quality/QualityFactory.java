package cn.edu.nju.software.game.fighting.model.factory.quality;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.Weapon;
import cn.edu.nju.software.game.fighting.model.item.intensify.IntensifyMaterial;
import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.skill.Skill;

public interface QualityFactory {

    Player createPlayer(Player player);

    Role createRole(Role role);

    Weapon createWeapon(Weapon weapon);

    Equipment createEquipment(Equipment equipment);

    IntensifyMaterial createIntensifyMaterial(IntensifyMaterial intensifyMaterial);

    Skill createSkill(Skill skill);

}
