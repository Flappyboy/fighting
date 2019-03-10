package cn.edu.nju.software.game.fighting.model.item.intensify.strategy.intensify;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.ability.SpecificAbility;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.intensify.IntensifyMaterial;
import cn.edu.nju.software.game.fighting.model.role.attribute.State;

import java.io.Serializable;

public class BaseIntensifyStrategy implements IIntensifyStrategy, Serializable {

    @Override
    public void intensify(Equipment target, IntensifyMaterial material) {

        if (!canIntensify(target, material)){
            target.say("");
        }
        intensifyAttackAbility(target.getAttackAbility(), material.getAttackAbility());
        intensifyDefenseAbility(target.getDefenseAbility(), material.getDefenseAbility());
        intensifySpecificAbility(target.getSpecificAbility(), material.getSpecificAbility());
        target.say(target.getName()+" 强化成功");
    }

    @Override
    public boolean canIntensify(Equipment target, IntensifyMaterial material) {
        return true;
    }

    protected void intensifyAttackAbility(AttackAbility target, AttackAbility attach){
        target.attachAbility(attach);
    }

    protected void intensifyDefenseAbility(DefenseAbility target, DefenseAbility attach){
        target.attachAbility(attach);
    }

    protected void intensifySpecificAbility(SpecificAbility target, SpecificAbility attach){
        target.attachAbility(attach);
    }
}
