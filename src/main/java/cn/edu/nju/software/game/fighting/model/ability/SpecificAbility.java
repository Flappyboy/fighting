package cn.edu.nju.software.game.fighting.model.ability;

import cn.edu.nju.software.game.fighting.model.role.attribute.State;

import java.util.HashMap;
import java.util.Map;

//特殊效果 概率
public class SpecificAbility {
    private Map<State, Float> stateMap = new HashMap<>();

    public SpecificAbility(){

    }

    public SpecificAbility clone(){
        SpecificAbility ability = new SpecificAbility();
        for (Map.Entry<State, Float> entry : stateMap.entrySet()) {
            ability.addAbilityValue(entry.getKey(),entry.getValue());
        }
        return ability;
    }

    public float getAbilityValue(State state) {
        Float value = stateMap.get(state);
        if(value == null){
            value = 0f;
        }
        return value;
    }

    public SpecificAbility addAbilityValue(State state, float increment) {
        if(increment==0)
            return this;

        float value = getAbilityValue(state);
        if(value == 0){
            stateMap.put(state, value);
        }

        value += increment;
        value = Math.min(value, 1);

        if(value<=0){
            stateMap.remove(state);
        }else{
            stateMap.put(state, value);
        }
        return this;
    }

    public SpecificAbility attachAbility(SpecificAbility attach){
        for(State state: State.allState()){
            addAbilityValue(state, attach.getAbilityValue(state));
        }
        return this;
    }

    public static SpecificAbility combineAbilitys(SpecificAbility ...abilitys){
        SpecificAbility result = new SpecificAbility();
        for (SpecificAbility ability:
                abilitys) {
            result.attachAbility(ability);
        }
        return result;
    }
}
