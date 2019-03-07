package cn.edu.nju.software.game.fighting.model.factory.mode;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.Weapon;
import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.skill.Skill;

public class NormalModeFactory implements ModeFactory {
    @Override
    public Player createPlayer(Player player) {
        return null;
    }

    @Override
    public Role createRole(Role role) {
        return null;
    }

    @Override
    public Weapon createWeapon(Weapon weapon) {
        return null;
    }

    @Override
    public Equipment createEquipment(Equipment equipment) {
        return null;
    }

    @Override
    public Skill createSkill(Skill skill) {
        return null;
    }
}
