package cn.edu.nju.software.game.fighting.model.factory.quality;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.Weapon;
import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.skill.Skill;

public class HighQualityFactory extends NormalQualityFactory {
    @Override
    public Player createPlayer(Player obj) {
        Player newObj = super.createPlayer(obj);

        return newObj;
    }

    @Override
    public Role createRole(Role obj) {
        Role newObj = super.createRole(obj);

        return newObj;
    }

    @Override
    public Weapon createWeapon(Weapon obj) {
        Weapon newObj = super.createWeapon(obj);

        return newObj;
    }

    @Override
    public Equipment createEquipment(Equipment obj) {
        Equipment newObj = super.createEquipment(obj);

        return newObj;
    }

    @Override
    public Skill createSkill(Skill obj) {
        Skill newObj = super.createSkill(obj);

        return newObj;
    }
}
