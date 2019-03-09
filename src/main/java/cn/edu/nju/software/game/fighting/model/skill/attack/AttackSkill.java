package cn.edu.nju.software.game.fighting.model.skill.attack;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.SpecificAbility;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.skill.Skill;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;

public class AttackSkill extends Skill {

    private AttackAbility attackAbility = new AttackAbility();

    private SpecificAbility specificAbility = new SpecificAbility();

    //策略模式
    private AttackStrategy attackStrategy = new PhysicalAttackStrategy();

    public AttackSkill(String name, Profession profession) {
        super(name, profession);
    }

    public static AttackSkill instanceWithAtk(String name, Profession profession, AttackAbility attackAbility){
        AttackSkill attackSkill = new AttackSkill(name, profession);
        attackSkill.setAttackAbility(attackAbility);
        return attackSkill;
    }

    public AttackSkill clone(){
        return CloneUtils.clone( this);
    }

    @Override
    public void performs(Game game, Role initiator, Role receiver) {

    }

    public AttackAbility getAttackAbility() {
        return attackAbility;
    }

    public void setAttackAbility(AttackAbility attackAbility) {
        this.attackAbility = attackAbility;
    }

    public SpecificAbility getSpecificAbility() {
        return specificAbility;
    }

    public void setSpecificAbility(SpecificAbility specificAbility) {
        this.specificAbility = specificAbility;
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    @Override
    public String getDesc() {
        return "攻击技能： "+name;
    }
}
