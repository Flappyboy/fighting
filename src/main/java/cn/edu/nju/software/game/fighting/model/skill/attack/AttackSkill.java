package cn.edu.nju.software.game.fighting.model.skill.attack;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.SpecificAbility;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.skill.Skill;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;
import org.apache.commons.lang3.RandomUtils;

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
        say(initiator.getName()+" 发动了技能："+this.getName());
        receiver.receiveAttack(attackStrategy.caculateAttack(initiator, this));
    }

    @Override
    public void intensify(int point) {
        getAttackAbility().addPhysical(point*2+ RandomUtils.nextInt(0,5));
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
        return "攻击技能： "+name+"  等级："+getLevel()+"  经验值："+getExp()+"  攻击力："+attackAbility.getPhysical();
    }
}
