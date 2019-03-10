package cn.edu.nju.software.game.fighting.model.item.intensify;

import cn.edu.nju.software.game.fighting.model.GameElement;
import cn.edu.nju.software.game.fighting.model.item.AbilityItem;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.Weapon;
import cn.edu.nju.software.game.fighting.model.item.intensify.strategy.intensify.BaseIntensifyStrategy;
import cn.edu.nju.software.game.fighting.model.item.intensify.strategy.intensify.IIntensifyStrategy;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;

public class IntensifyMaterial extends AbilityItem {
    private static final long serialVersionUID = 5918605443793657459L;
    IIntensifyStrategy intensifyStrategy = new BaseIntensifyStrategy();

    @Override
    public String getDesc() {
        return "强化材料 "+super.getDesc();
    }

    public IntensifyMaterial(String name) {
        super(name);
    }

    @Override
    public void use(GameElement gameElement) {
        if(gameElement == null){
            say("此为强化物品，需指定目标！");
        }else if(gameElement instanceof Equipment){
            Equipment equipment = (Equipment) gameElement;
            this.intensifyStrategy.intensify(equipment, this);
        }else{
            say("操作失败");
        }
    }

    public IntensifyMaterial clone(){
        return CloneUtils.clone( this);
    }

    public IIntensifyStrategy getIntensifyStrategy() {
        return intensifyStrategy;
    }

    public void setIntensifyStrategy(IIntensifyStrategy intensifyStrategy) {
        this.intensifyStrategy = intensifyStrategy;
    }
}
