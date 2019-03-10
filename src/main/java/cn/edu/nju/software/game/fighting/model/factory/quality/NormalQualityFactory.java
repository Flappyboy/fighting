package cn.edu.nju.software.game.fighting.model.factory.quality;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.Weapon;
import cn.edu.nju.software.game.fighting.model.item.intensify.IntensifyMaterial;
import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.skill.Skill;

public class NormalQualityFactory implements QualityFactory {
    Game game;

    public NormalQualityFactory(Game game) {
        this.game = game;
    }

    @Override
    public Player createPlayer(Player player) {
        Player r = player.clone();
        r.setGame(game);
        return r;
    }

    @Override
    public Role createRole(Role role) {
        Role r = role.clone();
        r.setGame(game);
        return r;
    }

    @Override
    public Weapon createWeapon(Weapon weapon) {
        Weapon w = weapon.clone();
        w.setGame(game);
        return w;
    }

    @Override
    public Equipment createEquipment(Equipment equipment) {
        Equipment item = equipment.clone();
        item.setGame(game);
        return item;
    }

    @Override
    public IntensifyMaterial createIntensifyMaterial(IntensifyMaterial intensifyMaterial) {
        IntensifyMaterial item = intensifyMaterial.clone();
        item.setGame(game);
        return item;
    }

    @Override
    public Skill createSkill(Skill skill) {
        Skill item = skill.clone();
        item.setGame(game);
        return item;
    }
}
