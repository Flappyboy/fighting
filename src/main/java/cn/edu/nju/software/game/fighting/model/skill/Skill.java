package cn.edu.nju.software.game.fighting.model.skill;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.GameElement;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.skill.strategy.upgrate.DefaultUpgrateStrategy;
import cn.edu.nju.software.game.fighting.model.skill.strategy.upgrate.UpgrateStrategy;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class Skill extends GameElement{
    private Integer level = 0;

    private Integer exp = 0;

    private UpgrateStrategy upgrateStrategy = new DefaultUpgrateStrategy();

    private Profession profession;

    public Skill(String name, Profession profession) {
        super(name);
        this.profession = profession;
    }

    boolean player = true;

    @Override
    public String getDesc() {
        return super.getDesc();
    }

    public void addExp(int exp, boolean player){
        this.player = player;
        upgrateStrategy.upgrate(this, exp);
    }

    @Override
    public void say(String log) {
        if(this.player)
            super.say(log);
    }

    public Skill clone(){
        return CloneUtils.clone( this);
    }

    public abstract void performs(Game game, Role initiator, Role receiver);

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

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        if(this.getProfession().equals(skill.getProfession()) && this.name.equals(skill.name)) return true;

        return false;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(profession)
                .toHashCode();
    }

    public abstract void intensify(int point);
}
