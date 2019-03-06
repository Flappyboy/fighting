package cn.edu.nju.software.game.fighting.model.skill;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.skill.upgrate.UpgrateStrategy;

public abstract class Skill {
    private String name;

    private Integer level;

    private Integer exp;

    private UpgrateStrategy upgrateStrategy;


    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void performs(Game game, Role initiator, Role receiver);

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public UpgrateStrategy getUpgrateStrategy() {
        return upgrateStrategy;
    }

    public void setUpgrateStrategy(UpgrateStrategy upgrateStrategy) {
        this.upgrateStrategy = upgrateStrategy;
    }
}
