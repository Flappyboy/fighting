package cn.edu.nju.software.game.fighting.model.ability;

import cn.edu.nju.software.game.fighting.model.role.attribute.State;

import java.util.HashMap;

//特殊效果 概率
public class SpecificAbility {
    private HashMap<State, Float> stateMap = new HashMap<>();

    public float getAbilityValue(State state) {
        Float value = stateMap.get(state);
        if(value == null){
            value = 0f;
        }
        return value;
    }

    public void addAbilityValue(State state, float increment) {
        float value = getAbilityValue(state);
        if(value == 0){
            stateMap.put(state, value);
        }
        value += increment;
        if(value<=0){
            stateMap.remove(state);
        }else{
            stateMap.put(state, value);
        }
    }


}
