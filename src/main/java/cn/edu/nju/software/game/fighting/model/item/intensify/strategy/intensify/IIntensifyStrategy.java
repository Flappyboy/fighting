package cn.edu.nju.software.game.fighting.model.item.intensify.strategy.intensify;

import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.intensify.IntensifyMaterial;

public interface IIntensifyStrategy {

    void intensify(Equipment target, IntensifyMaterial material);

    boolean canIntensify(Equipment target, IntensifyMaterial material);
}
