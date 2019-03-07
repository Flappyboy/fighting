package cn.edu.nju.software.game.fighting.model.item.intensify;

import cn.edu.nju.software.game.fighting.model.item.AbilityItem;
import cn.edu.nju.software.game.fighting.model.item.intensify.strategy.intensify.IIntensifyStrategy;

public class IntensifyMaterial extends AbilityItem {
    private static final long serialVersionUID = 5918605443793657459L;
    IIntensifyStrategy intensifyStrategy;

    public IntensifyMaterial(String name) {
        super(name);
    }

    public IIntensifyStrategy getIntensifyStrategy() {
        return intensifyStrategy;
    }

    public void setIntensifyStrategy(IIntensifyStrategy intensifyStrategy) {
        this.intensifyStrategy = intensifyStrategy;
    }
}
