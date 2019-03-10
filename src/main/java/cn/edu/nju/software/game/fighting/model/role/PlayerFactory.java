package cn.edu.nju.software.game.fighting.model.role;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;

import java.util.HashMap;
import java.util.Map;

public class PlayerFactory implements IRoleFactory{
    private static Map<Profession, Player> playerMap = new HashMap<>();

    private static PlayerFactory instance;

    public static PlayerFactory getInstance(){
        if (instance == null) {
            instance = new PlayerFactory();
        }
        return instance;
    }

    private PlayerFactory() {
        AttackAbility baseAttackAbility = new AttackAbility().addPhysical(10);
        DefenseAbility baseDefenseAbility = new DefenseAbility().addPhysical(10);
        Player player = new Player();
        player.setProfession(Profession.WARRIOR);
        put(player.getProfession(), player);
        player.setAttackAbility(baseAttackAbility.clone());
        player.setDefenseAbility(baseDefenseAbility.clone().addPhysical(1));

        player = new Player();
        player.setProfession(Profession.SWORDMAN);
        put(player.getProfession(), player);
        player.setAttackAbility(baseAttackAbility.clone().addPhysical(5));
        player.setDefenseAbility(baseDefenseAbility.clone());

        player = new Player();
        player.setProfession(Profession.MAGE);
        put(player.getProfession(), player);
        player.setAttackAbility(baseAttackAbility.clone());
        player.setDefenseAbility(baseDefenseAbility.clone());
    }

    private void put(Profession profession, Player player){
        playerMap.put(profession, player);
    }

    @Override
    public Role getRandomRole() {
        return playerMap.get(Profession.WARRIOR).clone();
    }

    @Override
    public Role getRole(Profession profession) {
        return playerMap.get(profession).clone();
    }
}
