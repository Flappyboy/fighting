package cn.edu.nju.software.game.fighting.model.role;

//Bridge pattern

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.ability.SpecificAbility;

public abstract class Role {
    Gender gender;
    BodyType bodyType;

    String id;
    String name;
    Integer level;
    Integer exp;

    AttackAbility attackAbility;
    DefenseAbility defenseAbility;
    SpecificAbility specificAbility;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

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

    public AttackAbility getAttackAbility() {
        return attackAbility;
    }

    public void setAttackAbility(AttackAbility attackAbility) {
        this.attackAbility = attackAbility;
    }

    public DefenseAbility getDefenseAbility() {
        return defenseAbility;
    }

    public void setDefenseAbility(DefenseAbility defenseAbility) {
        this.defenseAbility = defenseAbility;
    }

    public SpecificAbility getSpecificAbility() {
        return specificAbility;
    }

    public void setSpecificAbility(SpecificAbility specificAbility) {
        this.specificAbility = specificAbility;
    }
}
