package cn.edu.nju.software.game.fighting.model.factory.quality;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.Weapon;
import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.skill.Skill;

public class NormalQualityFactory implements QualityFactory {
    @Override
    public Player createPlayer(Player player) {
        return player.clone();
    }

    @Override
    public Role createRole(Role role) {
        return role.clone();
    }

    @Override
    public Weapon createWeapon(Weapon weapon) {
        return weapon.clone();
    }

    @Override
    public Equipment createEquipment(Equipment equipment) {
        return equipment.clone();
    }

    @Override
    public Skill createSkill(Skill skill) {
        return skill.clone();
    }
}
