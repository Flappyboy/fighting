package cn.edu.nju.software.game.fighting.model.skill;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.role.Role;

public abstract class Skill {
    String name;

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void performs(Game game, Role initiator, Role receiver);
}
