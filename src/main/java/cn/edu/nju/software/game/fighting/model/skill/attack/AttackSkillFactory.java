package cn.edu.nju.software.game.fighting.model.skill.attack;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.skill.SkillFactory;

public class AttackSkillFactory extends SkillFactory {

    private static AttackSkillFactory instance;

    public static AttackSkillFactory getInstance(){
        if (instance == null) {
            instance = new AttackSkillFactory();
        }
        return instance;
    }

    private AttackSkillFactory() {
        AttackAbility baseAttackAbility = new AttackAbility().addPhysical(1);

        add(AttackSkill.instanceWithAtk("轻拳", Profession.NONE, baseAttackAbility.clone()));
        add(AttackSkill.instanceWithAtk("轻脚", Profession.NONE, baseAttackAbility.clone()));
        addCombo(new AttackComboSkill("普通连击", this.skillList.get(this.skillList.size()-2), this.skillList.get(this.skillList.size()-1)));

        add(AttackSkill.instanceWithAtk("重拳", Profession.NONE, baseAttackAbility.clone().addPhysical(1)));
        add(AttackSkill.instanceWithAtk("重脚", Profession.NONE, baseAttackAbility.clone().addPhysical(2)));
        addCombo(new AttackComboSkill("超级连击", this.skillList.get(this.skillList.size()-2), this.skillList.get(this.skillList.size()-1)));

        add(AttackSkill.instanceWithAtk("暴怒拳", Profession.WARRIOR, baseAttackAbility.clone().addPhysical(2)));
        add(AttackSkill.instanceWithAtk("强力冲撞", Profession.WARRIOR, baseAttackAbility.clone().addPhysical(3)));
        add(AttackSkill.instanceWithAtk("砍", Profession.WARRIOR, baseAttackAbility.clone().addPhysical(5)));
        add(AttackSkill.instanceWithAtk("手刀", Profession.WARRIOR, baseAttackAbility.clone().addPhysical(5)));
        add(AttackSkill.instanceWithAtk("疯狂一击", Profession.WARRIOR, baseAttackAbility.clone().addPhysical(5)));
        add(AttackSkill.instanceWithAtk("风拳", Profession.WARRIOR, baseAttackAbility.clone().addPhysical(5)));
        add(AttackSkill.instanceWithAtk("one punch", Profession.WARRIOR, baseAttackAbility.clone().addPhysical(5)));
        addCombo(new AttackComboSkill("风之怒", this.skillList.get(this.skillList.size()-2), this.skillList.get(this.skillList.size()-1)));

        add(AttackSkill.instanceWithAtk("剑技", Profession.SWORDMAN, baseAttackAbility.clone().addPhysical(1)));
        add(AttackSkill.instanceWithAtk("劈", Profession.SWORDMAN, baseAttackAbility.clone().addPhysical(2)));
        add(AttackSkill.instanceWithAtk("刺", Profession.SWORDMAN, baseAttackAbility.clone().addPhysical(6)));
        add(AttackSkill.instanceWithAtk("武剑一击", Profession.SWORDMAN, baseAttackAbility.clone().addPhysical(6)));
        add(AttackSkill.instanceWithAtk("一闪", Profession.SWORDMAN, baseAttackAbility.clone().addPhysical(6)));

        add(AttackSkill.instanceWithAtk("普通攻击", Profession.MAGE, baseAttackAbility.clone().addPhysical(1)));
        add(AttackSkill.instanceWithAtk("小火球", Profession.MAGE, baseAttackAbility.clone().addPhysical(5)));
        add(AttackSkill.instanceWithAtk("雷击", Profession.MAGE, baseAttackAbility.clone().addPhysical(10)));

        add(AttackSkill.instanceWithAtk("小拳拳", Profession.NONE, baseAttackAbility.clone().addPhysical(1)));
        add(AttackSkill.instanceWithAtk("冲撞", Profession.NONE, baseAttackAbility.clone().addPhysical(3)));
        addCombo(new AttackComboSkill("疯狂连击", this.skillList.get(this.skillList.size()-2), this.skillList.get(this.skillList.size()-1)));
        add(AttackSkill.instanceWithAtk("拍脸", Profession.NONE, baseAttackAbility.clone().addPhysical(5)));
        add(AttackSkill.instanceWithAtk("怒吼", Profession.NONE, baseAttackAbility.clone().addPhysical(7)));

        add(AttackSkill.instanceWithAtk("扫堂腿", Profession.NONE, baseAttackAbility.clone().addPhysical(8)));
        add(AttackSkill.instanceWithAtk("连环踢", Profession.NONE, baseAttackAbility.clone().addPhysical(9)));
        addCombo(new AttackComboSkill("风神腿", this.skillList.get(this.skillList.size()-2), this.skillList.get(this.skillList.size()-1)));
    }
}
