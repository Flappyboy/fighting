package cn.edu.nju.software.game.fighting.model;

import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.Weapon;
import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.WeaponFactory;
import cn.edu.nju.software.game.fighting.model.item.intensify.IntensifyMaterialFactory;
import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.role.PlayerFactory;
import cn.edu.nju.software.game.fighting.model.role.attribute.Gender;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.role.exceptions.CannotLearnException;
import cn.edu.nju.software.game.fighting.model.skill.attack.AttackSkillFactory;
import cn.edu.nju.software.game.fighting.model.state.implement.BeginState;
import cn.edu.nju.software.game.fighting.model.state.implement.ForestState;
import cn.edu.nju.software.game.fighting.model.state.implement.SmithyState;

public abstract class BaseGameBuilder implements IGameBuilder {
    Game game = new Game("新的游戏");
    @Override
    public void buildPlayer(String name, Gender gender, Profession profession) {
        Player player = (Player) PlayerFactory.getInstance().getRole(profession);
        player.setName(name);
        game.setPlayer(game.getPlayerGameElementFactory().createPlayer(player));
    }

    @Override
    public void buildState() {
        game.setInitState(new ForestState(game));
    }

    @Override
    public Game result() {
        return game;
    }

    @Override
    public void buildInitItem() {
//        game.getPlayer().getBag().add(game.getPlayerGameElementFactory().createWeapon(WeaponFactory.getInstance().getInitWeapon(game.getPlayer().getProfession())));
        game.getPlayer().getBag().add(game.getPlayerGameElementFactory().createWeapon(WeaponFactory.getInstance().getInitWeapon(Profession.WARRIOR)));
        game.getPlayer().getBag().add(game.getPlayerGameElementFactory().createWeapon(WeaponFactory.getInstance().getInitWeapon(Profession.SWORDMAN)));
        game.getPlayer().getBag().add(game.getPlayerGameElementFactory().createWeapon(WeaponFactory.getInstance().getInitWeapon(Profession.MAGE)));
        game.getPlayer().getBag().add(game.getPlayerGameElementFactory().createIntensifyMaterial(IntensifyMaterialFactory.getInstance().getInitIntensifyMaterial()));
    }

    @Override
    public void buildInitSkill() {
        try {
            game.getPlayer().learnSkill(game.getPlayerGameElementFactory().createSkill(AttackSkillFactory.getInstance().randomSkill(game.getPlayer().getProfession())));
        } catch (CannotLearnException e) {
            e.printStackTrace();
        }
    }
}
